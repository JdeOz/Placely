package com.jd.placely.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    private var initEmail = true
    private var initUsername = true
    private var initPassword = true
    private var initReplyPassword = true

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _emailError = mutableStateOf(false)
    val emailError: State<Boolean> = _emailError

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _usernameError = mutableStateOf(false)
    val usernameError: State<Boolean> = _usernameError

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _passwordError = mutableStateOf(false)
    val passwordError: State<Boolean> = _passwordError

    private val _replyPasswordText = mutableStateOf("")
    val replyPasswordText: State<String> = _replyPasswordText

    private val _showReplyPassword = mutableStateOf(false)
    val showReplyPassword: State<Boolean> = _showReplyPassword

    private val _replyPasswordError = mutableStateOf(false)
    val replyPasswordError: State<Boolean> = _replyPasswordError


    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _registerError = mutableStateOf(false)
    val registerError: State<Boolean> = _registerError



    fun setEmailText(email: String) {
        if(initEmail){
            initEmail = false
        }
        _emailText.value = email
        _registerError.value = false
        validEmail()
    }

    private fun validEmail (){
        if(initEmail){
            _emailError.value = false
        }else{
            _emailError.value = !android.util.Patterns.EMAIL_ADDRESS.matcher(_emailText.value).matches()
        }
    }

    fun setUsernameText(username: String) {
        if(initUsername){
            initUsername = false
        }
        _usernameText.value = username
        _registerError.value = false
        validUsername()
    }

    private fun validUsername (){
        if(initUsername){
            _usernameError.value = false
        }else{
            _usernameError.value = (_usernameText.value.length<6)
        }
    }

    fun setPasswordText(password: String) {
        if(initPassword){
            initPassword = false
        }
        _passwordText.value = password
        _registerError.value = false
        validPassword()
        validReplyPassword()
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

    fun setReplyPasswordText(replyPassword: String) {
        if(initReplyPassword){
            initReplyPassword = false
        }
        _replyPasswordText.value = replyPassword
        _registerError.value = false
        validReplyPassword()
    }

    private fun validReplyPassword (){
        if(initReplyPassword){
            _replyPasswordError.value = false
        }else{
            _replyPasswordError.value = (_replyPasswordText.value!=_passwordText.value)
        }
    }

    fun setShowReplyPassword(showReplyPassword: Boolean) {
        _showReplyPassword.value = showReplyPassword
    }

}
