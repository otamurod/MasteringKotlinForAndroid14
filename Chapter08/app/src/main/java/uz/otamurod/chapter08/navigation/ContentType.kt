package uz.otamurod.chapter08.navigation

sealed interface ContentType {
    data object List : ContentType
    data object ListAndDetail : ContentType
}