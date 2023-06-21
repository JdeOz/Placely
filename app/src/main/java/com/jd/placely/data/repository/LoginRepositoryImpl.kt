package com.jd.placely.data.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jd.placely.domain.repository.LoginRepository
import com.jd.placely.util.Constants.SUPABASE_KEY
import com.jd.placely.util.Constants.SUPABASE_URL
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
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

//class LoginRepositoryImpl() : LoginRepository {
//    val client = createSupabaseClient(supabaseUrl = SUPABASE_URL, supabaseKey = SUPABASE_KEY){}
//    val gotrue = client.gotrue
//
//    override suspend fun login(email: String, password: String): Boolean {
//        client.gotrue.loginWith(Email) {
//            this.email = email
//            this.password = password
//        }
//        return true // Login successful
//
//    }
//}