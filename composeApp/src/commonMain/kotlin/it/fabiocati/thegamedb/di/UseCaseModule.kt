package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.domain.repository.EventRepository
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import it.fabiocati.thegamedb.domain.usecase.GetEventsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetEventsUseCaseImpl
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCaseImpl
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCaseImpl
import it.fabiocati.thegamedb.domain.usecase.GetSimilarGameUseCase
import it.fabiocati.thegamedb.domain.usecase.GetSimilarGameUseCaseImpl
import org.koin.dsl.module

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
    single<GetSimilarGameUseCase> {
        GetSimilarGameUseCaseImpl(
            gamesRepository = get<GamesRepository>()
        )
    }
    single<GetEventsUseCase> {
        GetEventsUseCaseImpl(
            eventRepository = get<EventRepository>()
        )
    }
}