package it.fabiocati.thegamedb.di

import io.ktor.client.HttpClient
import it.fabiocati.thegamedb.data.network.NetworkClientBuilder
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.data.network.TheGameDbServiceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClientBuilder().buildSimpleClient() }
    single(named("Auth-client")) { NetworkClientBuilder().buildAuthenticatedClient(get<HttpClient>()) }
    single<TheGameDbService> { TheGameDbServiceImpl(get(named("Auth-client"))) }
}