package com.example.instagram

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme
import java.util.regex.Pattern

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    //val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close the app",
        modifier = modifier.clickable { /*activity.finish()*/ })
}

@Composable
fun Body(modifier: Modifier) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isLoginEnabled by remember {
        mutableStateOf(true)
    }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Email(email = email, onTextChange = {
            email = it
            isLoginEnabled = enableLogin(email, password)
        }, modifier = modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Password(password = password, onTextChange ={
            password = it
            isLoginEnabled = enableLogin(email, password)
        }, modifier = modifier.fillMaxWidth() )
        Spacer(modifier = Modifier.height(16.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(modifier.fillMaxWidth(), isLoginEnabled)
        Spacer(modifier = Modifier.height(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.height(16.dp))
        SocialLogin()
        Spacer(modifier = Modifier.height(16.dp))
        Footer(modifier = Modifier.align(Alignment.CenterHorizontally))

    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ig_icon_dark),
        contentDescription = "Logo",
        modifier = modifier.clickable { })
}

@Composable
fun Email(email: String, onTextChange: (String) -> Unit, modifier: Modifier) {
    TextField(
        value = email,
        onValueChange = { onTextChange(it) },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun Password(password: String, onTextChange: (String) -> Unit, modifier: Modifier) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    TextField(
        value = password,
        onValueChange = { onTextChange(it) },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Password Icon")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot yor password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.LightGray,
        modifier = modifier.clickable { })
}

@Composable
fun LoginButton(modifier: Modifier ,loginEnabled: Boolean) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        enabled = loginEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EABE9),
            disabledBackgroundColor = Color(0xFF4EABE9),
            contentColor = Color.DarkGray,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Login")
    }
}

fun enableLogin(email: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 7
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color.Gray)
                .height(1.dp)
                .weight(1f)
        )

        Text(text = "OR")
        Divider(
            Modifier
                .background(Color.Gray)
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb_icon),
            contentDescription = "Facebook Logo",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Login with Facebook",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            modifier = modifier
                .background(Color.DarkGray)
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = modifier.height(24.dp))
        SignUp(modifier = modifier)
    }
}

@Composable
fun SignUp(modifier: Modifier) {
    Row(modifier = modifier) {
        Text(text = "Don't have an account?", fontSize = 12.sp, color = Color.Gray)

        Text(
            text = "Sign Up",
            fontSize = 12.sp,
            modifier = modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Cyan
        )
    }
}