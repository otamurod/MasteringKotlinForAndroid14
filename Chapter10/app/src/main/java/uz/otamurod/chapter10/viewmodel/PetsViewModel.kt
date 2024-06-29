package uz.otamurod.chapter10.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.otamurod.chapter10.data.Cat
import uz.otamurod.chapter10.data.NetworkResult
import uz.otamurod.chapter10.data.PetsRepository
import uz.otamurod.chapter10.data.asResult
import uz.otamurod.chapter10.views.PetsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {
    val petsUIState = MutableStateFlow(PetsUIState())
    private val _favoritePets = MutableStateFlow<List<Cat>>(emptyList())
    val favoritePets: StateFlow<List<Cat>> get() = _favoritePets

    init {
        getPets()
    }

    private fun getPets() {
        petsUIState.value = PetsUIState(isLoading = true)
        viewModelScope.launch {
            petsRepository.getPets().asResult().collect { result ->
                when (result ) {
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

    fun updatePet(cat: Cat) {
        viewModelScope.launch {
            petsRepository.updatePet(cat)
        }
    }

    fun getFavoritePets() {
        viewModelScope.launch {
            petsRepository.getFavoritePets().collect {
                _favoritePets.value = it
            }
        }
    }
}