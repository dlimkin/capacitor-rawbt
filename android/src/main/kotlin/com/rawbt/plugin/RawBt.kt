package com.rawbt.plugin

import android.content.Intent

/**
 * Implementation class for RawBT plugin.
 * Sends text to the RawBT thermal printer app via Android Intent.
 */
class RawBt {

    /**
     * Sends a print intent to the RawBT app.
     *
     * @param text     The text to print.
     * @param title    Title shown in the chooser dialog.
     * @param mimetype MIME type (e.g. "text/plain").
     * @return A configured Intent ready to be launched.
     */
    fun buildPrintIntent(text: String, title: String, mimetype: String): Intent {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = mimetype
        }
        return Intent.createChooser(sendIntent, title)
    }
}
