package uz.otamurod.chapter10.views

import uz.otamurod.chapter10.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
