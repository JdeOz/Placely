package com.jd.placely.presentation.register

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
import androidx.compose.ui.layout.ContentScale
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
//import com.jd.placely.presentation.components.StandardTextField
import com.jd.placely.presentation.ui.theme.*
import com.jd.placely.R
import com.jd.placely.presentation.register.RegisterViewModel
import com.jd.placely.presentation.util.Screen

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Image(
        painter = painterResource(id = R.drawable.circles),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
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
        Register(viewModel, navController)
        RegisterFeed(Modifier.align(Alignment.BottomCenter), navController)
    }
}


@Composable
fun Register(viewModel: RegisterViewModel, navController: NavController) {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        RegisterHeader()
        Spacer(modifier = Modifier.height(SpaceMedium))
        RegisterEmailField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        RegisterUsernameField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        RegisterPasswordField(viewModel)
        Spacer(modifier = Modifier.height(SpaceMedium))
        RegisterButton(Modifier.align(Alignment.CenterHorizontally), navController)
    }
}

@Composable
fun RegisterHeader() {
    Image(
        painter = painterResource(id = R.drawable.placely_logo),
        contentDescription = "Logo",
        modifier = Modifier.scale(0.5f) //TODO:Hacer responsive
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterEmailField(viewModel: RegisterViewModel) {
    OutlinedTextField(
        value = viewModel.emailText.value,
        onValueChange = { viewModel.setEmailText(it) },
        label = { Text("Email") },
        placeholder = { Text("Ingrese su Email") },
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
fun RegisterUsernameField(viewModel: RegisterViewModel) {
    OutlinedTextField(
        value = viewModel.usernameText.value,
        onValueChange = { viewModel.setUsernameText(it) },
        label = { Text("Nombre completo") },
        placeholder = { Text("Ingrese su nombre completo") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        ),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(24.dp)

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPasswordField(viewModel: RegisterViewModel) {
    OutlinedTextField(
        value = viewModel.passwordText.value,
        onValueChange = { viewModel.setPasswordText(it) },
        label = { Text("Contraseña") },
        placeholder = { Text("Ingrese su contraseña") },
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
fun RegisterButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = {
            navController.navigate(
                Screen.MainFeedScreen.route
            )
        },
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.register),
//                    color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun RegisterFeed(modifier: Modifier, navController: NavController) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(id = R.string.already_have_an_account))
            append(" ")
            val signUpText = stringResource(id = R.string.sign_in)
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
                navController.popBackStack()
                navController.navigate(Screen.LoginScreen.route)
            }
    )
}