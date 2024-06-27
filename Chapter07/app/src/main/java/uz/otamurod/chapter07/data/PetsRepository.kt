package uz.otamurod.chapter07.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}