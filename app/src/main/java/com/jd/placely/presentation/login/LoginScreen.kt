package com.jd.placely.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.jd.placely.presentation.register.RegisterViewModel
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
        Feed(Modifier.align(Alignment.BottomCenter), navController)
    }
}


@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize()) {
        Header()
        Spacer(modifier = Modifier.height(SpaceMedium))
        EmailField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        PasswordField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        LoginButton(Modifier.align(Alignment.End), navController)
    }
}

@Composable
fun Header() {
    Image(
        painter = painterResource(id = R.drawable.placely_logo),
        contentDescription = "Logo",
        modifier = Modifier.scale(0.5f)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(viewModel: LoginViewModel) {
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
        maxLines = 1,
        shape = RoundedCornerShape(24.dp)

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(viewModel: LoginViewModel) {
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
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    )
}

@Composable
fun LoginButton(modifier: Modifier, navController: NavController) {
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
fun Feed(modifier: Modifier, navController: NavController) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(id = R.string.dont_have_an_account_yet))
            append(" ")
            val signUpText = stringResource(id = R.string.sign_up)
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.secondary
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