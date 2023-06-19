package com.jd.placely.domain.repository

interface LoginRepository {
    suspend fun login(email: String, password: String): Boolean
}