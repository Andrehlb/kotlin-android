package com.example.kotlinandroid

import org.junit.Test
import org.junit.Assert.*

class AndroidUtilsTest {
    
    @Test
    fun `formatString should replace placeholders correctly`() {
        val template = "Hello {0}, you are {1} years old!"
        val result = AndroidUtils.formatString(template, "Alice", 25)
        assertEquals("Hello Alice, you are 25 years old!", result)
    }
    
    @Test
    fun `Preferences should store and retrieve values correctly`() {
        val prefs = AndroidUtils.Preferences()
        
        // Test default values
        assertEquals("", prefs.userName)
        assertEquals(0, prefs.userAge)
        assertTrue(prefs.isFirstLaunch)
        
        // Test setting values
        prefs.userName = "John Doe"
        prefs.userAge = 30
        prefs.isFirstLaunch = false
        
        assertEquals("John Doe", prefs.userName)
        assertEquals(30, prefs.userAge)
        assertFalse(prefs.isFirstLaunch)
    }
    
    @Test
    fun `ScreenSize should classify correctly`() {
        assertEquals(AndroidUtils.ScreenSize.SMALL, AndroidUtils.ScreenSize.fromWidth(300))
        assertEquals(AndroidUtils.ScreenSize.MEDIUM, AndroidUtils.ScreenSize.fromWidth(500))
        assertEquals(AndroidUtils.ScreenSize.LARGE, AndroidUtils.ScreenSize.fromWidth(800))
        assertEquals(AndroidUtils.ScreenSize.XLARGE, AndroidUtils.ScreenSize.fromWidth(1000))
    }
    
    @Test
    fun `ScreenSize isTablet should work correctly`() {
        assertFalse(AndroidUtils.ScreenSize.SMALL.isTablet())
        assertFalse(AndroidUtils.ScreenSize.MEDIUM.isTablet())
        assertTrue(AndroidUtils.ScreenSize.LARGE.isTablet())
        assertTrue(AndroidUtils.ScreenSize.XLARGE.isTablet())
    }
    
    @Test
    fun `letNotNull should work with nullable values`() {
        val nullValue: String? = null
        val nonNullValue: String? = "Hello"
        
        val result1 = with(AndroidUtils) { nullValue.letNotNull { it.uppercase() } }
        val result2 = with(AndroidUtils) { nonNullValue.letNotNull { it.uppercase() } }
        
        assertNull(result1)
        assertEquals("HELLO", result2)
    }
}