package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCaseImpl
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCaseImpl
import org.koin.dsl.module
import kotlin.math.sin

val useCaseModule = module {
    single<GetPopularGamesUseCase> {
        GetPopularGamesUseCaseImpl(
            gamesRepository = get<GamesRepository>(),
            popularityRepository = get<PopularityRepository>(),
        )
    }
    single<GetGameDetailsUseCase> {
        GetGameDetailsUseCaseImpl(
            gamesRepository = get<GamesRepository>()
        )
    }
}