package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import it.fabiocati.thegamedb.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        HomeViewModel(
            getPopularGamesUseCase = get<GetPopularGamesUseCase>()
        )
    }
}