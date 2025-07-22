package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.domain.usecase.GetEventsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import it.fabiocati.thegamedb.domain.usecase.GetSimilarGameUseCase
import it.fabiocati.thegamedb.ui.details.GameDetailsViewModel
import it.fabiocati.thegamedb.ui.home.HomeViewModel
import it.fabiocati.thegamedb.utils.UrlOpener
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        HomeViewModel(
            getPopularGamesUseCase = get<GetPopularGamesUseCase>()
        )
    }
    viewModel {
        GameDetailsViewModel(
            getGameDetailsUseCase = get<GetGameDetailsUseCase>(),
            getSimilarGameUseCase = get<GetSimilarGameUseCase>(),
            getEventsUseCase = get<GetEventsUseCase>(),
            urlOpener = get<UrlOpener>()
        )
    }
}