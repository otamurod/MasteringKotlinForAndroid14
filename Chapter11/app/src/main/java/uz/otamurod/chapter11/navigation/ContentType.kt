package uz.otamurod.chapter11.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}