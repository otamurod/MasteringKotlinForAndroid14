package uz.otamurod.chapter07.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import uz.otamurod.chapter07.views.FavoritePetsScreen
import uz.otamurod.chapter07.views.PetDetailsScreen
import uz.otamurod.chapter07.views.PetsScreen


@Composable
fun AppNavigation(
    contentType: ContentType,
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.PetsScreen.route
    ) {
        composable(Screens.PetsScreen.route) {
            PetsScreen(
                onPetClicked = { cat ->
                    navHostController.navigate(
                        "${Screens.PetDetailsScreen.route}/${Json.encodeToString(cat)}"
                    )
                },
                contentType = contentType
            )
        }
        composable(
            route = "${Screens.PetDetailsScreen.route}/{cat}",
            arguments = listOf(
                navArgument("cat") {
                    type = NavType.StringType
                }
            )
        ) {
            PetDetailsScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                cat = Json.decodeFromString(it.arguments?.getString("cat") ?: "")
            )
        }
        composable(Screens.FavoritePetsScreen.route) {
            FavoritePetsScreen()
        }
    }
}