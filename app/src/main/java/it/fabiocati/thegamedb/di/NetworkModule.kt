package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.network.NetworkClientBuilder
import it.fabiocati.thegamedb.data.network.TokenManager
import io.ktor.client.HttpClient
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.data.network.TheGameDbServiceImpl
import it.fabiocati.thegamedb.data.network.TokenManagerImpl
import it.fabiocati.thegamedb.data.storage.LocalStorage
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val AUTH_CLIENT_QUALIFIER = named("Auth-client")

val networkModule = module {
    single<HttpClient> {
        NetworkClientBuilder.buildSimpleClient()
    }
    single(AUTH_CLIENT_QUALIFIER) {
        NetworkClientBuilder.buildAuthenticatedClient(
            httpClient = get<HttpClient>(),
            tokenManager = get<TokenManager>()
        )
    }
    single<TokenManager> {
        TokenManagerImpl(
            localStorage = get<LocalStorage>()
        )
    }
    single<TheGameDbService> {
        TheGameDbServiceImpl(
            httpClient = get<HttpClient>(AUTH_CLIENT_QUALIFIER)
        )
    }
}