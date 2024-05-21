package com.example.flamingohotel.ui.theme.Screens.Final

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flamingohotel.R
import com.example.flamingohotel.ui.theme.NYPink


@Composable
fun FinalPage(navController:NavHostController) {
    Surface(
        color = NYPink,
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
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
            Text(text = "You have successfully booked your hotel room")
        }
    }
}

@Preview
@Composable
private fun FinalPrev() {
    FinalPage(rememberNavController())
}