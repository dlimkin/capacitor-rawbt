package com.rawbt.plugin

import android.content.Intent
import android.net.Uri

/**
 * Implementation class for RawBT plugin.
 * Sends base64-encoded data to the RawBT thermal printer app
 * via the custom URI scheme: rawbt:base64,{data}
 */
class RawBt {

    /**
     * Builds an Intent that opens the RawBT app with base64-encoded print data.
     *
     * @param base64str  Base64-encoded content to print.
     * @return A configured Intent ready to be launched.
     */
    fun buildPrintIntent(base64str: String): Intent {
        val url = "rawbt:base64,$base64str"
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
}
