package com.jd.placely.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jd.placely.presentation.components.StandardTextField
import com.jd.placely.presentation.ui.theme.*
import com.jd.placely.R
import com.jd.placely.presentation.util.Screen

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
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
fun Login(modifier: Modifier, viewModel: RegisterViewModel, navController: NavController) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize()) {
        HeaderText()
        Spacer(modifier = Modifier.height(SpaceMedium))
        EmailTextField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        PasswordTextField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        LoginButton(Modifier.align(Alignment.End), viewModel, navController)
    }
}

@Composable
fun HeaderText() {
    Text(
        text = stringResource(id = R.string.register),
//                style = MaterialTheme.typography.h1
    )
}

@Composable
fun EmailField(viewModel: RegisterViewModel) {
    StandardTextField(
        text = viewModel.usernameText.value,
        onValueChange = { viewModel.setUsernameText(it) },
        keyboardType = KeyboardType.Email,
        error = viewModel.usernameError.value,
        hint = stringResource(id = R.string.login_hint)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(viewModel: RegisterViewModel) {
    OutlinedTextField(
        value = viewModel.usernameText.value,
        onValueChange = { viewModel.setUsernameText(it) },
        label = { Text("Email address") },
        placeholder = { Text("Enter your email") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        singleLine = true,
        maxLines = 1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(viewModel: RegisterViewModel) {
    OutlinedTextField(
        value = viewModel.passwordText.value,
        onValueChange = { viewModel.setPasswordText(it) },
        label = { Text("Password") },
        placeholder = { Text("Enter your email") },
        visualTransformation = if (viewModel.showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { viewModel.setShowPassword(!viewModel.showPassword.value) }) {
                Icon(
                    imageVector = if (viewModel.showPassword.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (viewModel.showPassword.value) "Hide password" else "Show password"
                )
            }
        },
        isError = viewModel.passwordError.value.isNotEmpty(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier.fillMaxWidth()
        )
}

@Composable
fun PasswordField(viewModel: RegisterViewModel) {
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
fun LoginButton(modifier: Modifier, viewModel: RegisterViewModel, navController: NavController) {
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
fun Feed(modifier: Modifier, viewModel: RegisterViewModel, navController: NavController) {
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