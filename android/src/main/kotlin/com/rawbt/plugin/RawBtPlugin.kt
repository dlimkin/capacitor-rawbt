package com.rawbt.plugin

import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.annotation.CapacitorPlugin
import com.getcapacitor.PluginMethod

@CapacitorPlugin(name = "RawBt")
class RawBtPlugin : Plugin() {

    private val implementation = RawBt()

    @PluginMethod
    fun printBase64(call: PluginCall) {
        val base64str = call.getString("base64")
        if (base64str.isNullOrEmpty()) {
            call.reject("'base64' parameter is required and must not be empty")
            return
        }

        try {
            val intent = implementation.buildPrintIntent(base64str)
            activity.startActivity(intent)
            call.resolve()
        } catch (e: Exception) {
            call.reject("Failed to launch RawBT: ${e.message}", e)
        }
    }
}
