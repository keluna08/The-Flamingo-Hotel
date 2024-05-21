package com.example.flamingohotel.ui.theme.Screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flamingohotel.Model.AuthViewModel
import com.example.flamingohotel.Navigation.ROUTE_HOME

import com.example.flamingohotel.Navigation.ROUTE_REGISTER
import com.example.flamingohotel.R
import com.example.flamingohotel.ui.theme.Geraldine


@Composable
fun LoginScreen(navController:NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Surface(
        color = Geraldine,
        modifier = Modifier.fillMaxSize()
    ) {
        
            /// Content

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()

                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(80.dp)
                        .align(Alignment.CenterHorizontally)
                        .offset(x = (-20).dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Sign In",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text("Sign In now  ",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )


                OutlinedTextField(
                    value = text,
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription ="emailIcon" )
                    },
                    onValueChange ={
                        text = it
                    },
                    label = {
                        Text(text = "Email address")
                    },
                    placeholder = {
                        Text(text = "Enter your e-mail")
                    }


                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = pass,
                    leadingIcon = {
                        Icon(imageVector =Icons.Default.Lock, contentDescription ="lockicon" )
                    },
                    onValueChange ={
                        pass = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    placeholder = {
                        Text(text = "Enter your password")
                    }
                    
                )
Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    navController.navigate(ROUTE_HOME)
                    val mylogin= AuthViewModel(navController, context )
                    mylogin.login(text.text.trim(),pass.text.trim())
                }) {
                    Text(text = "Log in")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { 
                    navController.navigate(ROUTE_REGISTER)
                }) {
                    Text(text = "Don't have an account?Click to register")
                }

            }



    }

}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}

