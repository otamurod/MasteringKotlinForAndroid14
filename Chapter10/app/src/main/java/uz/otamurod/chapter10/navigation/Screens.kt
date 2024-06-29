package uz.otamurod.chapter10.navigation

sealed class Screens(val route: String) {
    object PetsScreen : Screens("pets")
    object PetDetailsScreen : Screens("petDetails")
    object FavoritePetsScreen : Screens("favoritePets")
}