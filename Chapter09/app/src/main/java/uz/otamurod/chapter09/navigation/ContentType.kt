package uz.otamurod.chapter09.navigation

sealed interface ContentType {
    data object List : ContentType
    data object ListAndDetail : ContentType
}