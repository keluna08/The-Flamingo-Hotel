package com.example.flamingohotel.ui.theme.Screens.BookingScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flamingohotel.Model.RoomViewModel
import com.example.flamingohotel.Navigation.ROUTE_FINAL
import com.example.flamingohotel.ui.theme.NYPink
import com.example.flamingohotel.ui.theme.Romancoffee



@Composable
fun BookingPage(navController:NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var RoomType by remember { mutableStateOf(TextFieldValue("")) }
    var CheckIn by remember { mutableStateOf(TextFieldValue("")) }
    var CheckOut by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current

    Surface(
        color = NYPink,
        modifier = Modifier.fillMaxSize()
    ) {
       Column(
           modifier = Modifier.fillMaxWidth()
       ) {
           Text(
               text = "The Flamingo",
               style = TextStyle(
                   color = Romancoffee,
                   fontSize = 30.sp,
                   fontFamily = FontFamily.Serif,
                   fontWeight = FontWeight.SemiBold
               )
           )
           Spacer(modifier = Modifier.height(10.dp))
           Text(
               text = "Enjoy and relax",
               style = TextStyle(
                   color = Romancoffee,
                   fontSize = 20.sp,
                   fontFamily = FontFamily.Cursive
               )
           )
           Spacer(modifier = Modifier.height(20.dp))


           val paddingModifier = Modifier.padding(10.dp)
           Card(
               elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
               modifier = paddingModifier
           ) {
               Column(
                   modifier = paddingModifier
               ) {
                   Text(text = "Single Room = KSH 5,000/night")
                   Text(text = "Double Bed Room = KSH 7,500/night")
                   Text(text = "Junior Suite = KSH 9,000/night")
                   Text(text = "Executive Suite = KSH 12,000/night")
                   Text(text = "Presidential Suite = KSH 20,000/night")
                   Spacer(modifier = Modifier.height(10.dp))
                   Text(text = "NOTE: payments will be done at the reception")
               }
           }
           Spacer(modifier = Modifier.height(20.dp))
           Text(
               text = "Fill In Your Details",
               style = TextStyle(
                   color = Romancoffee,
                   fontSize = 30.sp,
                   fontFamily = FontFamily.Serif,
                   fontWeight = FontWeight.SemiBold
               )
           )
           OutlinedTextField(value = name,
               label = {
                   Text(text = "Enter your name")
               },
               onValueChange = {
                   name = it
               })
           OutlinedTextField(value = email,
               label = {
                   Text(text = "Enter your email")
               },
               onValueChange = {
                   email = it
               })
           OutlinedTextField(value = RoomType,
               label = {
                   Text(text = "Room Type")
               },
               onValueChange = {
                   RoomType = it
               }
           )
           OutlinedTextField(value = CheckIn,
               label = {
                   Text(text = "Date of Checking In")
               },
               onValueChange = {
                   CheckIn = it
               })
           OutlinedTextField(value = CheckOut,
               label = {
                   Text(text = "Date of Checking Out")
               },
               onValueChange = {
                   CheckOut = it
               })
           Button(onClick = {
               navController.navigate(ROUTE_FINAL)
                val RoomRepository = RoomViewModel(navController, context)
                RoomRepository.saveRoom(name.text.trim(),email.text.trim(),RoomType.text.trim(),CheckIn
                         .text.trim(),CheckOut.text.trim())

           }) {
               Text(text = "Book")

           }

       }
    }
}

@Preview
@Composable
private fun Bookingprev() {
    BookingPage(rememberNavController())
}