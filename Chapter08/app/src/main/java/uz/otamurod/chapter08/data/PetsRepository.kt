package uz.otamurod.chapter08.data

import kotlinx.coroutines.flow.Flow
import uz.otamurod.chapter08.data.Cat
import uz.otamurod.chapter08.data.NetworkResult

interface PetsRepository {
    suspend fun getPets(): Flow<List<Cat>>
    suspend fun fetchRemotePets()
    suspend fun updatePet(cat: Cat)
    suspend fun getFavoritePets(): Flow<List<Cat>>
}