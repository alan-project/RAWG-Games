package net.alanproject.rawg_private.ui.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import net.alanproject.domain.model.params.ListParams
import net.alanproject.rawg_private.ui.detail.DetailScreen
import net.alanproject.rawg_private.ui.favorite.FavoriteScreen
import net.alanproject.rawg_private.ui.list.ListScreen
import net.alanproject.rawg_private.ui.main.MainScreen
import net.alanproject.rawg_private.ui.navigation.NavigationItem
import timber.log.Timber


@Composable
fun Navigation(navController: NavHostController) {

    Timber.d("[LoadingError] Navigation is called")

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        //navGraphBuilder to control how to build the navigation Graph
        //and navGraph is a map of screens
        composable(NavigationItem.Home.route) {

            MainScreen(navController)
        }

        composable(NavigationItem.List.route) {
            ListScreen(navController = navController)
        }
        composable(NavigationItem.Favorite.route) {
            FavoriteScreen()
        }

        composable(
            route = "rank/{params}/{bottomNav}",
            arguments = listOf(
                navArgument("params") { type = NavType.StringType },
                navArgument("bottomNav") { type = NavType.StringType })
        ) { navBackStackEntry ->

            val listParamsString: String =
                navBackStackEntry.arguments?.getString("params").orEmpty()
            Timber.d("listParamsString: $listParamsString")
            val listParams: ListParams = Gson().fromJson(listParamsString, ListParams::class.java)
            Timber.d("listParams: $listParams")
            ListScreen(listParams, navController)
        }

        composable(
            route = "detail/{gameId}/{bottomNav}",
            arguments = listOf(
                navArgument("gameId") { type = NavType.IntType },
                navArgument("bottomNav") { type = NavType.StringType }
            )
        ) { navBackStackEntry ->

            DetailScreen(navBackStackEntry.arguments?.getInt("gameId") ?: 0, navController)
        }
    }
}