package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import it.fabiocati.thegamedb.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        HomeViewModel(
            gamesRepository = get<GamesRepository>(),
            popularityRepository = get<PopularityRepository>()
        )
    }
}