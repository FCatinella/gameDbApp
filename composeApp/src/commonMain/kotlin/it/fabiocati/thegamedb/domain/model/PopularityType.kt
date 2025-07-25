package it.fabiocati.thegamedb.domain.model

enum class PopularityType(val id: Int) {
    VISITS(1),
    WANT_TO_PLAY(2),
    PLAYING(3),
    PLAYED(4),
    STEAM_MOST_PLAYED_24H(5)
}