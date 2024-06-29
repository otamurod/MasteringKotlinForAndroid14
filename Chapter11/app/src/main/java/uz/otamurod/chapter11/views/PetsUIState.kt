package uz.otamurod.chapter11.views

import uz.otamurod.chapter11.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)