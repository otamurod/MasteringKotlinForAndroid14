package uz.otamurod.chapter08.views

import uz.otamurod.chapter08.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
