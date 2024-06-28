package uz.otamurod.chapter08.navigation

sealed interface NavigationType {
    data object BottomNavigation : NavigationType
    data object NavigationDrawer : NavigationType
    data object NavigationRail : NavigationType
}