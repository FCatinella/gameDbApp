package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InvolvedCompanyDataModel(
    @SerialName("id")
    val id : Int,
    @SerialName("company")
    val company: CompanyDataModel,
    @SerialName("developer")
    val developer: Boolean,
    @SerialName("game")
    val gameId: Int
)