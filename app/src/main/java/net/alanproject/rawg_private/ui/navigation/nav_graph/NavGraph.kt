package net.alanproject.rawg_private.ui.navigation.nav_graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import net.alanproject.domain.model.params.ListParams
import net.alanproject.rawg_private.ui.detail.DetailScreen
import net.alanproject.rawg_private.ui.favorite.FavoriteScreen
import net.alanproject.rawg_private.ui.list.ListScreen
import net.alanproject.rawg_private.ui.main.MainScreen
import net.alanproject.rawg_private.ui.navigation.BottomNavigationBar
import net.alanproject.rawg_private.ui.navigation.NavigationItem
import timber.log.Timber

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            if (CurrentRoute(navController) != "hide") {
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
fun CurrentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Timber.d("navBackStackEntry, route: ${navBackStackEntry?.arguments?.getString("route")}")
    Timber.d("navBackStackEntry, list: ${navBackStackEntry?.arguments?.getString("list")}")
    Timber.d("navBackStackEntry, rank: ${navBackStackEntry?.arguments?.getString("rank")}")
    Timber.d("navBackStackEntry, params: ${navBackStackEntry?.arguments?.getString("params")}")
    Timber.d("navBackStackEntry, bottomNav: ${navBackStackEntry?.arguments?.getString("bottomNav")}")
    return navBackStackEntry?.arguments?.getString("bottomNav")
}
