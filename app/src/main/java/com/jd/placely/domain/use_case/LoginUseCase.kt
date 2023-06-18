package com.jd.placely.domain.use_case

import com.jd.placely.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return loginRepository.login(email, password)
    }
}