package uz.otamurod.chapter06.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.otamurod.chapter06.views.PetsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.otamurod.chapter06.data.NetworkResult
import uz.otamurod.chapter06.data.PetsRepository

class PetsViewModel(
    private val petsRepository: PetsRepository
) : ViewModel() {
    val petsUIState = MutableStateFlow(PetsUIState())

    init {
        getPets()
    }

    private fun getPets() {
        petsUIState.value = PetsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = petsRepository.getPets()) {
                is NetworkResult.Success -> {
                    petsUIState.update {
                        it.copy(isLoading = false, pets = result.data)
                    }
                }

                is NetworkResult.Error -> {
                    petsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
}