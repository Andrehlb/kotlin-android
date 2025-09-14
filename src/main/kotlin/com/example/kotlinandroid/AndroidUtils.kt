package com.example.kotlinandroid

/**
 * Utility class demonstrating various Kotlin features commonly used in Android development
 */
object AndroidUtils {
    
    /**
     * Simulate Android-style resource string formatting
     */
    fun formatString(template: String, vararg args: Any): String {
        var result = template
        args.forEachIndexed { index, arg ->
            result = result.replace("{$index}", arg.toString())
        }
        return result
    }
    
    /**
     * Simulate Android-style preference management using delegation
     */
    class Preferences {
        private val prefs = mutableMapOf<String, Any>()
        
        var userName: String by PreferenceDelegate("user_name", "")
        var userAge: Int by PreferenceDelegate("user_age", 0)
        var isFirstLaunch: Boolean by PreferenceDelegate("first_launch", true)
        
        inner class PreferenceDelegate<T>(
            private val key: String,
            private val defaultValue: T
        ) {
            @Suppress("UNCHECKED_CAST")
            operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): T {
                return prefs[key] as? T ?: defaultValue
            }
            
            operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: T) {
                prefs[key] = value as Any
            }
        }
    }
    
    /**
     * Enum class for representing different Android screen sizes
     */
    enum class ScreenSize(val dp: Int) {
        SMALL(320),
        MEDIUM(480),
        LARGE(720),
        XLARGE(960);
        
        fun isTablet(): Boolean = this >= LARGE
        
        companion object {
            fun fromWidth(widthDp: Int): ScreenSize {
                return values().lastOrNull { widthDp >= it.dp } ?: SMALL
            }
        }
    }
    
    /**
     * Higher-order function for safe operations (similar to Android's safe calls)
     */
    inline fun <T, R> T?.letNotNull(block: (T) -> R): R? {
        return this?.let(block)
    }
    
    /**
     * Inline function for logging (simulating Android Log.d)
     */
    inline fun logDebug(tag: String, message: () -> String) {
        println("DEBUG/$tag: ${message()}")
    }
}