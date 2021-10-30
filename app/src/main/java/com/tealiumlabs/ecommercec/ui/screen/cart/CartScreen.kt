package com.tealiumlabs.ecommercec.ui.screen.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.ui.navigation.Screen

@Composable
fun CartScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Screen.Cart.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(16.dp)
        )

        Icon(imageVector = Screen.Cart.icon, contentDescription = "Cart", modifier = Modifier.fillMaxSize(0.3f))
    }
}