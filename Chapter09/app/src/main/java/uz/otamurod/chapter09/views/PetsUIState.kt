package uz.otamurod.chapter09.views

import uz.otamurod.chapter09.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
