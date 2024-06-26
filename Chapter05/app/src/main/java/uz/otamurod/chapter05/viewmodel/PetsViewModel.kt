package uz.otamurod.chapter05.viewmodel

import androidx.lifecycle.ViewModel
import uz.otamurod.chapter05.data.PetsRepository

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {

    fun getPets() = petsRepository.getPets()
}