package com.rawbt.plugin

import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.annotation.CapacitorPlugin
import com.getcapacitor.PluginMethod

@CapacitorPlugin(name = "RawBt")
class RawBtPlugin : Plugin() {

    private val implementation = RawBt()

    @PluginMethod
    fun print(call: PluginCall) {
        val text = call.getString("text")
        if (text == null) {
            call.reject("'text' parameter is required")
            return
        }
        val title = call.getString("title") ?: "Print via RawBT"
        val mimetype = call.getString("mimetype") ?: "text/plain"

        try {
            val intent = implementation.buildPrintIntent(text, title, mimetype)
            activity.startActivity(intent)
            call.resolve()
        } catch (e: Exception) {
            call.reject("Failed to launch RawBT: ${e.message}", e)
        }
    }
}

