package com.jd.placely.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jd.placely.presentation.components.StandardTextField
import com.jd.placely.presentation.ui.theme.*
import com.jd.placely.R
import com.jd.placely.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Login(Modifier, viewModel, navController)
        Feed(Modifier.align(Alignment.BottomCenter), viewModel, navController)
    }
}


@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize()) {
        HeaderText()
        Spacer(modifier = Modifier.height(SpaceMedium))
        EmailField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        PasswordField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        LoginButton(Modifier.align(Alignment.End), viewModel, navController)
    }
}

@Composable
fun HeaderText() {
    Text(
        text = stringResource(id = R.string.login),
//                style = MaterialTheme.typography.h1
    )
}

@Composable
fun EmailField(viewModel: LoginViewModel) {
    StandardTextField(
        text = viewModel.usernameText.value,
        onValueChange = { viewModel.setUsernameText(it) },
        keyboardType = KeyboardType.Email,
        error = viewModel.usernameError.value,
        hint = stringResource(id = R.string.login_hint)
    )
}

@Composable
fun PasswordField(viewModel: LoginViewModel) {
    StandardTextField(
        text = viewModel.passwordText.value,
        onValueChange = { viewModel.setPasswordText(it) },
        hint = stringResource(id = R.string.password_hint),
        keyboardType = KeyboardType.Password,
        error = viewModel.passwordError.value,
        isPasswordVisible = viewModel.showPassword.value,
        onPasswordToggleClick = { viewModel.setShowPassword(it) }
    )
}

@Composable
fun LoginButton(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {
    Button(
        onClick = {
            navController.navigate(
                Screen.MainFeedScreen.route
            )
        },
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.login),
//                    color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun Feed(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(id = R.string.dont_have_an_account_yet))
            append(" ")
            val signUpText = stringResource(id = R.string.sign_up)
            withStyle(
                style = SpanStyle(
//                        color = MaterialTheme.colors.primary
                    color = Color.White
                )
            ) {
                append(signUpText)
            }
        },
//            style = MaterialTheme.typography.body1,
        modifier = modifier
            .clickable {
                navController.navigate(
                    Screen.RegisterScreen.route
                )
            }
    )
}