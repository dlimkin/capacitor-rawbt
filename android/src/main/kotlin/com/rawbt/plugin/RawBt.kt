package com.rawbt.plugin

import android.content.Intent
import android.net.Uri
import android.util.Base64

/**
 * Implementation class for RawBT plugin.
 * Sends data to the RawBT thermal printer app via the custom URI scheme:
 *   rawbt:base64,{base64data}
 */
class RawBt {

    /**
     * Builds an Intent that opens the RawBT app with plain text.
     * The text is encoded to UTF-8 bytes and then to Base64.
     *
     * @param text  Plain text content to print.
     * @return A configured Intent ready to be launched.
     */
    fun buildPrintTextIntent(text: String): Intent {
        val base64str = Base64.encodeToString(text.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
        return buildPrintBase64Intent(base64str)
    }

    /**
     * Builds an Intent that opens the RawBT app with pre-encoded Base64 data.
     *
     * @param base64str  Base64-encoded content to print (e.g. ESC/POS commands).
     * @return A configured Intent ready to be launched.
     */
    fun buildPrintBase64Intent(base64str: String): Intent {
        val url = "rawbt:base64,$base64str"
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
}
