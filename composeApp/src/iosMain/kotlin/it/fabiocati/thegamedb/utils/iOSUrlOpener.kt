package it.fabiocati.thegamedb.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

class iOSUrlOpener() : UrlOpener {
    override fun open(url: String) {
        val nsurl = NSURL(string = url)
        UIApplication.sharedApplication.openURL(
            url = nsurl,
            options = emptyMap<Any?, String>(),
            completionHandler = null,
        )
    }
}