package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResult(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("expires_in")
    val expireIn: Long,
    @SerialName("token_type")
    val tokenType: String,
)