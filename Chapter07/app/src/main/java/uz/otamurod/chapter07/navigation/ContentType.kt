package uz.otamurod.chapter07.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}