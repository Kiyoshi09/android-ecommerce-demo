package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun CustomTextField(
    textValue: String,
    bgColor: Color,
    stateValue: MutableState<String>,
    passwordVisibility: MutableState<Boolean> = mutableStateOf(true),
    focusRequestN: FocusRequester,
    focusRequestN1: FocusRequester,
    fontSize: TextUnit,
    icon: ImageVector,
){
    BasicTextField(
        value = stateValue.value,
        onValueChange = { stateValue.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .focusOrder(focusRequestN) {
                focusRequestN1.requestFocus()
            },
        visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        textStyle = EcommTypography.h5.copy(
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.background(bgColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                        )
                        .size(16.dp)
                )
                if (stateValue.value.isEmpty()) {
                    Text(
                        text = textValue,
                        style = EcommTypography.h5.copy(
                            color = Neutral2,
                            fontSize = fontSize
                        )
                    )
                }
                innerTextField()
            }
        }
    )
}