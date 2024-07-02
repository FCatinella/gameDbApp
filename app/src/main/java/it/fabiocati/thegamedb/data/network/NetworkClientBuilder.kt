package it.fabiocati.thegamedb.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import it.fabiocati.thegamedb.BuildConfig
import it.fabiocati.thegamedb.data.model.TokenResult
import kotlinx.serialization.json.Json

private const val CLIENT_ID_HEADER_KEY = "Client-ID"
private const val CLIENT_ID_PARAMETER_KEY = "client_id"
private const val CLIENT_SECRET_PARAMETER_KEY = "client_secret"
private const val GRANT_TYPE_PARAMETER_KEY = "grant_type"

object NetworkClientBuilder {

    fun buildSimpleClient(): HttpClient {
        return HttpClient(OkHttp.create { }).config {
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    fun buildAuthenticatedClient(httpClient: HttpClient, tokenManager: TokenManager): HttpClient {
        val refreshingTokenClient = httpClient.config { }

        return httpClient.config {
            defaultRequest {
                headers {
                    append(CLIENT_ID_HEADER_KEY, BuildConfig.CLIENT_ID)
                }
            }

            install(Auth) {
                bearer {
                    loadTokens {
                        val accessToken = tokenManager.getAccessToken() ?: return@loadTokens null
                        BearerTokens(accessToken, "")
                    }
                    refreshTokens {
                        val result = refreshingTokenClient.post {
                            url {
                                protocol = URLProtocol.HTTPS
                                host = "id.twitch.tv"
                                path("oauth2/token")
                            }
                            parameter(CLIENT_ID_PARAMETER_KEY, BuildConfig.CLIENT_ID)
                            parameter(CLIENT_SECRET_PARAMETER_KEY, BuildConfig.CLIENT_SECRET)
                            parameter(GRANT_TYPE_PARAMETER_KEY, "client_credentials")
                        }
                        val token = try {
                            result.body<TokenResult>()
                        } catch (e: Exception) {
                            return@refreshTokens null
                        }
                        tokenManager.saveAccessToken(token.accessToken)
                        BearerTokens(token.accessToken, "")
                    }
                }
            }
        }
    }
}