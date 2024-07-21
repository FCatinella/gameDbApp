package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.data.model.PopularityType
import it.fabiocati.thegamedb.domain.model.Game

interface GetPopularGamesUseCase {
    suspend operator fun invoke(popularityType: PopularityType, limit: Int = 15): List<Game>
}