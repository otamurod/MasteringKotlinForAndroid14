package uz.otamurod.chapter12.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}