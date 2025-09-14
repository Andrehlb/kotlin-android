package com.example.kotlinandroid

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.async

/**
 * Main entry point for the Kotlin Android Demo application.
 * This demonstrates Kotlin language features that are commonly used in Android development.
 */
fun main() {
    println("=== Kotlin Android Demo ===")
    
    // Demonstrate basic Kotlin features
    demonstrateBasicFeatures()
    
    // Demonstrate collections and higher-order functions
    demonstrateCollections()
    
    // Demonstrate data classes (commonly used in Android)
    demonstrateDataClasses()
    
    // Demonstrate coroutines (essential for Android development)
    demonstrateCoroutines()
    
    println("=== Demo Complete ===")
}

fun demonstrateBasicFeatures() {
    println("\n1. Basic Kotlin Features:")
    
    // Null safety
    val nullableString: String? = null
    val safeLength = nullableString?.length ?: 0
    println("Safe string length: $safeLength")
    
    // String templates
    val name = "Kotlin"
    println("Hello, $name! Length: ${name.length}")
    
    // When expression (similar to switch but more powerful)
    val platform = "Android"
    val message = when (platform) {
        "Android" -> "Mobile development with Kotlin!"
        "JVM" -> "Server-side development with Kotlin!"
        else -> "Kotlin everywhere!"
    }
    println("Platform message: $message")
}

fun demonstrateCollections() {
    println("\n2. Collections and Higher-Order Functions:")
    
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // Map transformation
    val doubled = numbers.map { it * 2 }
    println("Original: $numbers")
    println("Doubled: $doubled")
    
    // Filter operation
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")
    
    // Reduce operation
    val sum = numbers.reduce { acc, n -> acc + n }
    println("Sum: $sum")
}

fun demonstrateDataClasses() {
    println("\n3. Data Classes:")
    
    val user1 = User("Alice", "alice@example.com", 25)
    val user2 = User("Bob", "bob@example.com", 30)
    val user3 = user1.copy(age = 26) // Copy with modifications
    
    println("User 1: $user1")
    println("User 2: $user2")
    println("User 3 (copy of user 1 with different age): $user3")
    
    // Destructuring
    val (name, email, age) = user1
    println("Destructured - Name: $name, Email: $email, Age: $age")
}

fun demonstrateCoroutines() {
    println("\n4. Coroutines (Essential for Android):")
    
    runBlocking {
        println("Starting coroutine...")
        delay(1000) // Simulate async operation
        println("Coroutine completed after delay!")
        
        // Demonstrate async operations
        val deferred1 = async { computeValue("Task 1", 500) }
        val deferred2 = async { computeValue("Task 2", 300) }
        
        println("Results: ${deferred1.await()}, ${deferred2.await()}")
    }
}

suspend fun computeValue(taskName: String, delayMs: Long): String {
    delay(delayMs)
    return "$taskName completed"
}

/**
 * Data class representing a user - commonly used pattern in Android apps
 */
data class User(
    val name: String,
    val email: String,
    val age: Int
) {
    // Custom methods can be added to data classes
    fun isAdult(): Boolean = age >= 18
    
    fun getDisplayName(): String = "$name <$email>"
}