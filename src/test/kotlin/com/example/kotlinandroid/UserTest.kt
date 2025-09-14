package com.example.kotlinandroid

import org.junit.Test
import org.junit.Assert.*

class UserTest {
    
    @Test
    fun `User data class should work correctly`() {
        val user = User("Alice", "alice@example.com", 25)
        
        assertEquals("Alice", user.name)
        assertEquals("alice@example.com", user.email)
        assertEquals(25, user.age)
    }
    
    @Test
    fun `isAdult should return true for age 18 and above`() {
        val adult = User("Adult", "adult@example.com", 18)
        val child = User("Child", "child@example.com", 17)
        
        assertTrue("18 should be adult", adult.isAdult())
        assertFalse("17 should not be adult", child.isAdult())
    }
    
    @Test
    fun `getDisplayName should format correctly`() {
        val user = User("John Doe", "john@example.com", 30)
        assertEquals("John Doe <john@example.com>", user.getDisplayName())
    }
    
    @Test
    fun `copy should create new instance with modified properties`() {
        val original = User("Alice", "alice@example.com", 25)
        val copied = original.copy(age = 26)
        
        assertEquals("Alice", copied.name)
        assertEquals("alice@example.com", copied.email)
        assertEquals(26, copied.age)
        assertNotSame(original, copied)
    }
    
    @Test
    fun `data class equality should work correctly`() {
        val user1 = User("Alice", "alice@example.com", 25)
        val user2 = User("Alice", "alice@example.com", 25)
        val user3 = User("Bob", "bob@example.com", 25)
        
        assertEquals(user1, user2)
        assertNotEquals(user1, user3)
    }
    
    @Test
    fun `destructuring should work correctly`() {
        val user = User("Alice", "alice@example.com", 25)
        val (name, email, age) = user
        
        assertEquals("Alice", name)
        assertEquals("alice@example.com", email)
        assertEquals(25, age)
    }
}