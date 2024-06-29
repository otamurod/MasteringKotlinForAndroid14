package uz.otamurod.chapter09.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("_id")
    val id: String,
    @SerialName("owner")
    val owner: String = "",
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("isFavorite")
    val isFavorite: Boolean = false
)