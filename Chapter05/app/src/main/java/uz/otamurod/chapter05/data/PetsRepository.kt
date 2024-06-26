package uz.otamurod.chapter05.data

interface PetsRepository {
    fun getPets(): List<Pet>
}