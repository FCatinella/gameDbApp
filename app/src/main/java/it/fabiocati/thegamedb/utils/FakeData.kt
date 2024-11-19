package it.fabiocati.thegamedb.utils

import it.fabiocati.thegamedb.domain.model.Game
import kotlinx.datetime.LocalDate
import java.time.Month

val redDeadRedemption2 = Game(
    id = "42",
    name = "Red Dead Redemption 2",
    coverUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co1q1f.webp",
    screenshotUrls = listOf(),
    artworkUrls = listOf(),
    developmentCompany = "Rockstar north",
    genre = "Western",
    dateOfRelease = LocalDate(year = 2017, month = Month.OCTOBER, dayOfMonth = 10)
)