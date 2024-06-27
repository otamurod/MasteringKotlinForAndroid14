package uz.otamurod.chapter06.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}