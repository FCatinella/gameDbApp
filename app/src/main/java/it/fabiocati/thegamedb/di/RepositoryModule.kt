package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.data.repository.GamesRepositoryImpl
import it.fabiocati.thegamedb.data.repository.PopularityRepositoryImpl
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<GamesRepository> { GamesRepositoryImpl(gameDbService = get<TheGameDbService>()) }
    single<PopularityRepository> { PopularityRepositoryImpl(gameDbService = get<TheGameDbService>()) }
}