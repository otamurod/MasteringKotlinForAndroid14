package uz.otamurod.chapter08.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.otamurod.chapter08.data.Cat

interface CatsAPI {
    @GET("cats")
    suspend fun fetchCats(
        @Query("tag") tag: String,
    ): Response<List<Cat>>
}