package com.example.flamingohotel.ui.theme.Screens.Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.flamingohotel.Navigation.ROUTE_LOGIN
import com.example.flamingohotel.R

import com.example.flamingohotel.ui.theme.Geraldine
import com.example.flamingohotel.ui.theme.Romancoffee



@Composable
fun RegisterScreen(navController : NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var  pass by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
   Surface(
       color = Geraldine,
       modifier = Modifier.fillMaxSize()
    ) {

       /// Content
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .padding(horizontal = 24.dp)
       ) {


//            Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(80.dp)
                            .align(Alignment.CenterHorizontally)
                        .offset(x = (-20).dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

           Text(
               text = "Sign Up",
               style = TextStyle(
                   fontSize = 28.sp,
                   fontFamily = FontFamily.Serif,
                   fontWeight = FontWeight(500),
                   color = Color.White
               ),
               modifier = Modifier.align(Alignment.Start)
           )
           Spacer(modifier = Modifier.height(10.dp))

           Text(
               "Create your account.",
               style = TextStyle(
                   fontSize = 20.sp,
                   fontFamily = FontFamily.Serif,
                   color = Color(0xB2FFFFFF)
               ),
               modifier = Modifier
                   .align(Alignment.Start)
                   .padding(bottom = 24.dp)
           )
           Spacer(modifier = Modifier.height(15.dp))


           // Text Field

           OutlinedTextField(
               value = name,
               leadingIcon = {
                   Icon(imageVector = Icons.Default.Person, contentDescription = "person")
               },
               onValueChange = { name = it },
               label = {
                   Text(text = " Full Name")
               },
               placeholder = {
                   Text(text = "Enter your full name")
               }

           )
           Spacer(modifier = Modifier.height(10.dp))
           OutlinedTextField(
               value = text,
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Default.Email,
                       contentDescription = "emailIcon"
                   )
               },
               onValueChange = {
                   text = it
               },
               label = {
                   Text(text = "Email address")
               },
               placeholder = {
                   Text(text = "Enter your E-mail")
               }

           )
           Spacer(modifier = Modifier.height(10.dp))
           OutlinedTextField(
               value = pass,
               leadingIcon = {
                   Icon(imageVector = Icons.Default.Lock, contentDescription = "lockicon")
               },
               onValueChange = {
                   pass = it
               },
               label = {
                   Text(text = "Password")
               },
               placeholder = {
                   Text(text = "Enter your password")
               }


           )
           Spacer(modifier = Modifier.height(10.dp))
           OutlinedTextField(
               value = confirmpass,
               leadingIcon = {
                   Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock icon")
               },
               onValueChange = {
                   confirmpass = it
               },
               label = {
                   Text(text = "Confirm your password")
               },
               placeholder = {
                   Text(text = "Confirm password")
               }
           )
           Spacer(modifier = Modifier.height(10.dp))
           Button(onClick = {
               navController.navigate(ROUTE_HOME)
               val myregister = AuthViewModel(navController, context)
               myregister.signup(
                   text.text.trim(),
                   pass.text.trim(),
                   confirmpass.text.trim()
               )

           }) {
               Text(text = "Register")


           }

           Row(
               modifier = Modifier.padding(top = 12.dp, bottom = 52.dp)
           ) {
               Text(
                   "Already have an account?,Sign In ",
                   style = TextStyle(
                       fontSize = 18.sp,
                       fontFamily = FontFamily.Serif,
                       color = Color.White
                   )
               )
           }

           Button(onClick = {
               navController.navigate(ROUTE_LOGIN)
           }) {
               Text(text = "Sign In")
           }
       }


   }

    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 640)
    @Composable
    fun RegisterScreenPrev() {
        RegisterScreen(rememberNavController())
    }


