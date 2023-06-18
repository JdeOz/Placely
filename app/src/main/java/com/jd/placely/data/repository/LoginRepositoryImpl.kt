package com.jd.placely.data.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jd.placely.domain.repository.LoginRepository
import kotlinx.coroutines.tasks.await

class LoginRepositoryImpl() : LoginRepository {
    private val auth = Firebase.auth

    override suspend fun login(email: String, password: String): Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true // Login successful
        } catch (e: Exception) {
            false // Login failed
        }
    }
}