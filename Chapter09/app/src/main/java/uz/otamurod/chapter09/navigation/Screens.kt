package uz.otamurod.chapter09.navigation

sealed class Screens(val route: String) {
    data object PetsScreen : Screens("pets")
    data object PetDetailsScreen : Screens("petDetails")
    data object FavoritePetsScreen : Screens("favoritePets")
}