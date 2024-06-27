package uz.otamurod.chapter06.views

import uz.otamurod.chapter06.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
