package net.alanproject.rawg_private

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import net.alanproject.domain.model.params.ListParams
import net.alanproject.rawg_private.ui.detail.DetailScreen
import net.alanproject.rawg_private.ui.favorite.FavoriteScreen
import net.alanproject.rawg_private.ui.list.ListScreen
import net.alanproject.rawg_private.ui.main.MainScreen
import net.alanproject.rawg_private.ui.main.MainViewModel
import net.alanproject.rawg_private.ui.navigation.BottomNavigationBar
import net.alanproject.rawg_private.ui.navigation.NavigationItem
import timber.log.Timber

@Composable
fun TopScreen(){
    val navController = rememberNavController()
    Scaffold(
    bottomBar = { BottomNavigationBar(navController)
    }
    ){ innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){

            Navigation(navController)
        }
    }
}

@Composable
fun Navigation(navController:NavHostController){

    Timber.d("[LoadingError] Navigation is called")

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        //navGraphBuilder to control how to build the navigation Graph
        //and navGraph is a map of screens
        composable(NavigationItem.Home.route) {

            MainScreen(navController)
        }

        composable(NavigationItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(NavigationItem.List.route) {
            ListScreen(navController = navController)
        }

        composable(
            route = "list/{params}",
            arguments = listOf(navArgument("params") { type = NavType.StringType })
        ) { navBackStackEntry ->

            val listParamsString:String = navBackStackEntry.arguments?.getString("params").orEmpty()
            Timber.d("listParamsString: $listParamsString")
            val listParams: ListParams = Gson().fromJson(listParamsString, ListParams::class.java)
            Timber.d("listParams: $listParams")
            Timber.d("[LoadingError] Navigate to ListScreen")
            ListScreen(listParams, navController)
        }

        composable(
            route = "detail/{gameId}",
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) { navBackStackEntry ->

            DetailScreen(navBackStackEntry.arguments!!.getInt("gameId"), navController)
        }




    }
}