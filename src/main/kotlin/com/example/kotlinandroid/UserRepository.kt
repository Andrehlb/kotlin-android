package com.example.kotlinandroid

/**
 * Repository pattern commonly used in Android apps for data management.
 * This demonstrates Kotlin features like:
 * - Sealed classes for representing different states
 * - Extension functions
 * - Coroutines for async operations
 */
class UserRepository {
    private val users = mutableListOf<User>()
    
    fun addUser(user: User): Result<User> {
        return try {
            users.add(user)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }
    }
    
    fun getUserByEmail(email: String): Result<User> {
        val user = users.find { it.email == email }
        return if (user != null) {
            Result.Success(user)
        } else {
            Result.Error("User not found")
        }
    }
    
    fun getAllUsers(): List<User> = users.toList()
    
    fun getUserCount(): Int = users.size
}

/**
 * Sealed class for representing operation results - common pattern in Android
 */
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    
    // Extension function for Result
    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error
}

/**
 * Extension functions - very useful in Android development
 */
fun String.isValidEmail(): Boolean {
    return this.contains("@") && this.contains(".") && 
           this.indexOf("@") > 0 && this.indexOf("@") < this.lastIndexOf(".")
}

fun List<User>.filterAdults(): List<User> {
    return this.filter { it.isAdult() }
}

fun List<User>.averageAge(): Double {
    return if (this.isEmpty()) 0.0 else this.map { it.age }.average()
}