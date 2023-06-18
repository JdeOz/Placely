package com.jd.placely.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.jd.placely.domain.use_case.LoginUseCase
import com.jd.placely.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {
    private var initEmail = true
    private var initPassword = true

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf(false)
    val emailError: State<Boolean> = _emailError

    private val _passwordError = mutableStateOf(false)
    val passwordError: State<Boolean> = _passwordError

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _loginError = mutableStateOf(false)
    val loginError: State<Boolean> = _loginError

    fun setEmailText(email: String) {
        if(initEmail){
            initEmail = false
        }
        _emailText.value = email
        _loginError.value = false
        validEmail()
    }

    fun setPasswordText(password: String) {
        if(initPassword){
            initPassword = false
        }
        _passwordText.value = password
        _loginError.value = false
        validPassword()
    }

    private fun validEmail (){
        if(initEmail){
            _emailError.value = false
        }else{
            _emailError.value = !android.util.Patterns.EMAIL_ADDRESS.matcher(_emailText.value).matches()
        }
    }

    private fun validPassword (){
        if(initPassword){
            _passwordError.value = false
        }else{
            _passwordError.value = (_passwordText.value.length<6)
        }
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }
    fun login(navController:NavController) {
        viewModelScope.launch {
            _isLoading.value = true
            _loginError.value = false
            val result = loginUseCase(emailText.value, passwordText.value)
            if (result) {
                navController.popBackStack()
                navController.navigate(Screen.MainFeedScreen.route)
            } else {
                _isLoading.value = false
                _loginError.value = true
                _emailError.value = true
                _passwordError.value = true
            }

        }
    }
}
