package it.fabiocati.thegamedb

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import it.fabiocati.thegamedb.utils.UrlOpener

class AndroidUrlOpener(
    private val context: Context
) : UrlOpener {
    override fun open(url: String) {
        context.openExternalUrl(url)
    }

}

private fun Context.openExternalUrl(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(browserIntent)
}