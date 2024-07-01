package uz.otamurod.chapter12.views

import uz.otamurod.chapter12.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)