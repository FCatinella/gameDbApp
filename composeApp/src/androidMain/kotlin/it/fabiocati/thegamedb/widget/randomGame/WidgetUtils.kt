package it.fabiocati.thegamedb.widget.randomGame

fun String.takeOrFull(size: Int): String {
    if (this.length < size) return this
    return this.take(size) + "..."
}