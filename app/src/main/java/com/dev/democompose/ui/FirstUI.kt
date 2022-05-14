package com.dev.democompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.security.AccessController

@Composable
fun firstUI(
    navController: NavController
){
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate(Screen.SecondUI.route)}, modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Empty State"
            )
        }
        Spacer(modifier = Modifier.width(4.dp))

        Button(onClick = { navController.navigate(Screen.ThirdUI.route)}, modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Value State"
            )
        }
    }
}