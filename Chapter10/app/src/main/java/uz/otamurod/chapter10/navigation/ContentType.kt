package uz.otamurod.chapter10.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}