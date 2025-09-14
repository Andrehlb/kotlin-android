package com.example.kotlinandroid

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class UserRepositoryTest {
    
    private lateinit var repository: UserRepository
    
    @Before
    fun setup() {
        repository = UserRepository()
    }
    
    @Test
    fun `addUser should return Success result`() {
        val user = User("John Doe", "john@example.com", 25)
        val result = repository.addUser(user)
        
        assertTrue("Should return Success", result.isSuccess())
        when (result) {
            is Result.Success -> assertEquals(user, result.data)
            is Result.Error -> fail("Should not return Error")
        }
    }
    
    @Test
    fun `getUserByEmail should return user when exists`() {
        val user = User("Jane Doe", "jane@example.com", 30)
        repository.addUser(user)
        
        val result = repository.getUserByEmail("jane@example.com")
        
        assertTrue("Should return Success", result.isSuccess())
        when (result) {
            is Result.Success -> assertEquals(user, result.data)
            is Result.Error -> fail("Should not return Error")
        }
    }
    
    @Test
    fun `getUserByEmail should return Error when user not found`() {
        val result = repository.getUserByEmail("nonexistent@example.com")
        
        assertTrue("Should return Error", result.isError())
        when (result) {
            is Result.Success -> fail("Should not return Success")
            is Result.Error -> assertEquals("User not found", result.message)
        }
    }
    
    @Test
    fun `getUserCount should return correct count`() {
        assertEquals(0, repository.getUserCount())
        
        repository.addUser(User("User1", "user1@example.com", 25))
        assertEquals(1, repository.getUserCount())
        
        repository.addUser(User("User2", "user2@example.com", 30))
        assertEquals(2, repository.getUserCount())
    }
}