package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyDataModel(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
)