package uz.otamurod.chapter07.views

import uz.otamurod.chapter07.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
