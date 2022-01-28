package net.alanproject.rawg_private

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.alanproject.rawg_private.ui.list.ListScreen
import net.alanproject.rawg_private.ui.main.MainScreen
import net.alanproject.rawg_private.ui.main.MainViewModel

@Composable
fun RawgApp() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {

        //navGraphBuilder to control how to build the navigation Graph
        //and navGraph is a map of screens
        composable(route = "main_screen") {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(mainViewModel, navController)
        }

        //pass parameter
        composable(
            route = "list/{categoryId}",
            arguments = listOf(navArgument("categoryId") {
                type = NavType.LongType
            })
        ) { navBackStackEntry ->

            ListScreen(navBackStackEntry.arguments!!.getInt("categoryId"), navController)
        }
    }

}