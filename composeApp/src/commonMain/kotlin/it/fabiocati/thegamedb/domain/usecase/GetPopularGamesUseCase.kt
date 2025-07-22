package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.PopularityType

interface GetPopularGamesUseCase {
    suspend operator fun invoke(popularityType: PopularityType, limit: Int = 15, recentGames: Boolean = false): List<Game>
}