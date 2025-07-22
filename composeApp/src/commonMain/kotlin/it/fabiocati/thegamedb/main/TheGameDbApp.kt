package it.fabiocati.thegamedb.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import it.fabiocati.thegamedb.navigation.Routes
import it.fabiocati.thegamedb.ui.details.GameDetailsRoute
import it.fabiocati.thegamedb.ui.home.HomeRoute
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun TheGameDbApp() {
    val navController = rememberNavController()

    TheGameDbTheme {
        NavHost(navController = navController, startDestination = Routes.Home) {
            composable<Routes.Home> {
                HomeRoute(
                    navigator = navController
                )
            }
            composable<Routes.Detail>(
                deepLinks = listOf(
                    navDeepLink<Routes.Detail>(
                        basePath = "app://gamedb.fabiocati.it"
                    )
                )
            ) {
                val route: Routes.Detail = it.toRoute()
                GameDetailsRoute(
                    gameId = route.gameId,
                    navigator = navController
                )
            }
        }
    }
}
