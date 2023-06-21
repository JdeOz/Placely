package com.jd.placely.data.repository

import com.jd.placely.domain.repository.LoginRepository
import com.jd.placely.util.Constants.SUPABASE_KEY
import com.jd.placely.util.Constants.SUPABASE_URL
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest

class LoginRepositoryImpl() : LoginRepository {
    val client = createSupabaseClient(supabaseUrl = SUPABASE_URL, supabaseKey = SUPABASE_KEY){
        install(GoTrue)
        install(Postgrest)
    }

    override suspend fun login(email: String, password: String): Boolean {
        return try {
            client.gotrue.loginWith(Email) {
                this.email = email
                this.password = password
            }
            true // Login successful
        } catch (e: Exception) {
            false // Login failed
        }
    }
}