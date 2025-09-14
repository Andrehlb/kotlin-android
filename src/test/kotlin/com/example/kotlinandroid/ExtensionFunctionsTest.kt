package com.example.kotlinandroid

import org.junit.Test
import org.junit.Assert.*

class ExtensionFunctionsTest {
    
    @Test
    fun `isValidEmail should validate email correctly`() {
        assertTrue("valid@example.com".isValidEmail())
        assertTrue("user.name@domain.co.uk".isValidEmail())
        
        assertFalse("invalid.email".isValidEmail())
        assertFalse("@domain.com".isValidEmail())
        assertFalse("user@".isValidEmail())
        assertFalse("".isValidEmail())
    }
    
    @Test
    fun `filterAdults should return only adult users`() {
        val users = listOf(
            User("Child1", "child1@example.com", 16),
            User("Adult1", "adult1@example.com", 18),
            User("Child2", "child2@example.com", 17),
            User("Adult2", "adult2@example.com", 25)
        )
        
        val adults = users.filterAdults()
        
        assertEquals(2, adults.size)
        assertTrue(adults.all { it.isAdult() })
        assertEquals("Adult1", adults[0].name)
        assertEquals("Adult2", adults[1].name)
    }
    
    @Test
    fun `averageAge should calculate correctly`() {
        val users = listOf(
            User("User1", "user1@example.com", 20),
            User("User2", "user2@example.com", 30),
            User("User3", "user3@example.com", 40)
        )
        
        assertEquals(30.0, users.averageAge(), 0.01)
    }
    
    @Test
    fun `averageAge should return 0 for empty list`() {
        val emptyList = emptyList<User>()
        assertEquals(0.0, emptyList.averageAge(), 0.01)
    }
}