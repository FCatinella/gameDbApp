package it.fabiocati.thegamedb.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs

@Composable
fun TheGameDbApp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DestinationsNavHost(
            navGraph = NavGraphs.root,
            modifier = Modifier.weight(1f)
        )
        NavigationBar {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = { Icon(Icons.Filled.Search, contentDescription = "Search") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = { Icon(Icons.Filled.Menu, contentDescription = "Menu") }
            )
        }
    }
}