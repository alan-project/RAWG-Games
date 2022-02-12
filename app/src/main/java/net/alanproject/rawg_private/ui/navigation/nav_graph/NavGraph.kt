package net.alanproject.rawg_private.ui.navigation.nav_graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.alanproject.rawg_private.ui.navigation.BottomNavigationBar


@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {

            if (currentRoute(navController) != "hide") {

                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Navigation(navController)
        }
    }
}

@Composable

fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    return navBackStackEntry?.arguments?.getString("bottomNav")
}
