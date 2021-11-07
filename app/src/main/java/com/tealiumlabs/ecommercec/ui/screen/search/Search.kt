package com.tealiumlabs.ecommercec.ui.screen.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class, androidx.compose.animation.ExperimentalAnimationApi::class)
@Composable
fun SearchBar(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    onBack: () -> Unit,
    searching: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
       modifier = Modifier.fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically
    ){
       AnimatedVisibility(visible = focused) {
           // Back button
           IconButton(
               onClick = {
                   focusManager.clearFocus()
                   keyboardController?.hide()
                   onBack()
               },
           modifier = Modifier.padding(start = 2.dp)) {
              Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
           }
       }

       SearchTextField(
           query = query,
           onQueryChange = onQueryChange,
           onSearchFocusChange = onSearchFocusChange,
           onClearQuery = onClearQuery,
           searching = searching,
           focused = focused,
           modifier = modifier.weight(1f)
       )
    }
}

@Composable
fun SearchTextField(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    searching: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
){
    val focusRequester = remember { FocusRequester() }

    Surface(
        modifier = modifier
            .then(
                Modifier
                    .height(56.dp)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = if (!focused) 16.dp else 0.dp,
                        end = 16.dp
                    )
            ),
        color = Color(0xffF5F5F5),
        shape = RoundedCornerShape(percent = 50)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = modifier
        ) {

            if(query.text.isEmpty()) {
                SearchHint(modifier.padding(start = 24.dp, end = 8.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
               BasicTextField(
                   value = query,
                   onValueChange = onQueryChange,
                   modifier = Modifier
                       .fillMaxHeight()
                       .weight(1f)
                       .onFocusChanged {
                           onSearchFocusChange(it.isFocused)
                       }
                       .focusRequester(focusRequester)
                       .padding(top = 9.dp, bottom = 8.dp, start = 24.dp, end = 8.dp),
                   singleLine = true
               )

               when {
                   searching -> {
                       CircularProgressIndicator(
                           modifier = Modifier
                               .padding(horizontal = 6.dp)
                               .size(36.dp)
                       )
                   }
                   query.text.isNotEmpty() -> {
                       IconButton(onClick = onClearQuery) {
                           Icon(imageVector = Icons.Filled.Cancel, contentDescription = null)
                       }
                   }
               }
            }
        }
    }
}

@Composable
fun SearchHint(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)

    ) {
        Text(
            color = Color(0xff757575),
            text = "Search a Tag or Description",
        )
    }
}

@Composable
fun <R, S> rememberSearchState(
    query: TextFieldValue = TextFieldValue(""),
    focused: Boolean = false,
    searching: Boolean = false,
    suggestions: List<S> = emptyList(),
    searchResults: List<R> = emptyList()
): SearchState<R, S> {
    return remember {
        SearchState(
            query = query,
            focused = focused,
            searching = searching,
            suggestions = suggestions,
            searchResults = searchResults
        )
    }
}

@Stable
class SearchState<R, S>(
   query: TextFieldValue,
   focused: Boolean,
   searching: Boolean,
   suggestions: List<S>,
   searchResults: List<R>
){
    var query by mutableStateOf(query)
    var focused by mutableStateOf(focused)
    var searching by mutableStateOf(searching)
    var suggestions by mutableStateOf(suggestions)
    var searchResults by mutableStateOf(searchResults)

    val searchDisplay: SearchDisplay
        get() = when {
            !focused && query.text.isEmpty() -> SearchDisplay.InitialResults
            focused && query.text.isEmpty() -> SearchDisplay.Suggestions
            searchResults.isEmpty() -> SearchDisplay.NoResults
            else -> SearchDisplay.Results
        }

    override fun toString(): String {
        return "🚀 State query: $query, focused: $focused, searching: $searching " +
                "suggestions: ${suggestions.size}, " +
                "searchResults: ${searchResults.size}, " +
                " searchDisplay: $searchDisplay"

    }
}

enum class SearchDisplay {
    InitialResults, Suggestions, Results, NoResults
}