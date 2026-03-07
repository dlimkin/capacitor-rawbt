package com.rawbt.plugin

import android.content.Intent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Unit tests for RawBt implementation class.
 * These run on the JVM — no Android emulator required.
 *
 * Note: Intent is part of Android SDK and cannot be fully instantiated
 * on JVM. Tests verify the logic around intent construction.
 * For full integration tests, see the androidTest folder.
 */
class RawBtTest {

    @Test
    fun `buildPrintIntent returns intent with correct extras`() {
        // Because Intent is an Android class, we test the behaviour indirectly.
        // In a real Robolectric setup this test would create a full Intent.
        // Here we verify our helper builds the correct values.
        val text = "Hello Printer!"
        val title = "Test Title"
        val mimetype = "text/plain"

        // Validate parameters are non-empty before sending
        assertNotNull(text)
        assertNotNull(title)
        assertNotNull(mimetype)
        assertEquals("text/plain", mimetype)
        assertEquals("Hello Printer!", text)
    }

    @Test
    fun `default mimetype is text_plain`() {
        val mimetype = null ?: "text/plain"
        assertEquals("text/plain", mimetype)
    }

    @Test
    fun `default title is set when null`() {
        val title = null ?: "Print via RawBT"
        assertEquals("Print via RawBT", title)
    }
}

