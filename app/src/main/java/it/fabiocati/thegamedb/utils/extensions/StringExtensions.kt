package it.fabiocati.thegamedb.utils.extensions

fun String.getImageUrl(): String = this.replace("//", "https://").replace("t_thumb", "t_1080p")