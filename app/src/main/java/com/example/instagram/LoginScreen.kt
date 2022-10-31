package com.example.instagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme

@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp) ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close the app", modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Body(modifier: Modifier){
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Email(email){email=it}
        Spacer(modifier = Modifier.height(8.dp))
        Password(password){password=it}
        Spacer(modifier = Modifier.height(16.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(true)
    }
}

@Composable
fun ImageLogo(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.ig_icon_dark), contentDescription = "Logo", modifier = modifier.clickable {  })
}

@Composable
fun Email(email:String, onTextChange:(String)->Unit){
    TextField(value = email, onValueChange = {onTextChange(it)}, modifier = Modifier.fillMaxWidth() )
}


@Composable
fun Password(password: String, onTextChange: (String)->Unit){
    TextField(value = password, onValueChange = {onTextChange(it)}, modifier = Modifier.fillMaxWidth())
}

@Composable
fun ForgotPassword(modifier: Modifier){
    Text(text = "Forgot yor password?", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.LightGray, modifier = modifier.clickable {  })
}

@Composable
fun LoginButton(loginEnabled: Boolean){
    Button(onClick = { /*TODO*/ }, modifier =  Modifier.fillMaxWidth(), enabled = loginEnabled) {
        Text(text = "Login")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    InstagramTheme {
        LoginScreen()
    }
}