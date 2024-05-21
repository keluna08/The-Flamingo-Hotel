package com.example.flamingohotel.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flamingohotel.Navigation.ROUTE_BOOKING
import com.example.flamingohotel.R
import com.example.flamingohotel.ui.theme.Cararra
import com.example.flamingohotel.ui.theme.NYPink
import com.example.flamingohotel.ui.theme.Romancoffee


//data class RoomModel(val name:String,val description:String,val imageId:Int)
//
//
//
//@Composable
//fun ListofRooms(items:List<RoomModel>,onItemClick:(RoomModel)-> Unit) {
//    Surface(
//        color = Cararra,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Row (
//            modifier = Modifier
//                .fillMaxSize()
//        ){
//            Text(text = "The Flamingo Hotel",
//                style = TextStyle(
//                    color = Romancoffee,
//                    fontSize = 30.sp,
//                    fontFamily = FontFamily.Serif,
//                    fontWeight = FontWeight.SemiBold
//                )
//
//            )
//            Spacer(modifier = Modifier.height(15.dp))
//            Text(text = "Enjoy and relax",
//                style = TextStyle(
//                    color = Romancoffee,
//                    fontSize = 20.sp,
//                    fontFamily = FontFamily.Cursive
//                )
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//
//          LazyRow {
//              items(items){item ->
//                  Card (
//                      modifier = Modifier.padding(8.dp),
//                      elevation = 4.dp
//                  ){
//                      Column(modifier = Modifier
//                          .fillMaxWidth()
//                          .fillMaxHeight()
//                          ) {
//                          Text(text = item.name,
//                              modifier = Modifier.padding(16.dp)
//                          )
//                          Text(text = item.description,
//                              modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
//                          )
//                          Image(painter = painterResource(id = item.imageId), contentDescription = null,
//                          modifier = Modifier
//                              .fillMaxWidth()
//                              .height(200.dp),
////                              contentScale = content.Crop
//                          )
//                          Button(onClick = { onItemClick(item) },
//                              modifier = Modifier
////                                  .align(LineHeightStyle.Alignment.Bottom)
//                                  .padding(16.dp)
//                          ) {
//                             Text(text = "Book")
//                          }
//                      }
//                  }
//              }
//          }
//
//
//            }
//
//            }
//
//        val RoomList = mutableListOf<RoomModel>().apply {
//            add(
//                RoomModel("Single Room","Experience luxury in our single bedroom at The Flamingo Hotel: opulent furnishings,king-sized bed , stunning nature views, and a spa-like ensuite bathroom.",
//                    R.drawable.single),
//                RoomModel("Double bed room", "Experience unparalleled comfort and sophistication in our double bedroom suite at The Flamingo Hotel:spacious retreat,luxurious furnishings,panoramic nature views and modern amenities.",R.drawable.db),
//                RoomModel("Junior Suite", "Indulge in luxury at our Junior Suite in The Flamingo Hotel:chic and ambient decor,nature views which will all ensure a sophisticated memomarable stay.",R.drawable.js),
//                RoomModel("Executive Suite","Immerse yourself in unmatched luxury at The Flamingo Hotel's Executive Suite:where grandeur,refinement,panoramic nature viewsand lavishness converge to create an unforgettable retreat.",R.drawable.es),
//                RoomModel("Presidential Suite", "Embark on an extraordinary journey of luxury and exclusivity in our Presidential suite at the illustrious The Flamingo Hotel.",R.drawable.ps)
//
//            )
//        }
//
//
//
//
//
//
//
//       ListofRooms(items = RoomList) {
//           selectedItem ->
//           navController.navigate(ROUTE_BOOKING)
//       }
//
//    }
//
//
//
//
//
data class RoomModel(val name:String,val description : String, val image : Int)

@Composable
fun ListRow(model: RoomModel) {
    Column(
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(NYPink)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .width(120.dp)
                .padding(5.dp)
        )
        Text(

            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Romancoffee
        )
        Text(
            text =model.description,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

    }
}
private val roomList = mutableListOf<RoomModel>().apply {

    add(RoomModel("Single Room","Experience luxury in our single bedroom at The Flamingo Hotel: opulent furnishings,king-sized bed , stunning nature views, and a spa-like ensuite bathroom.", R.drawable.single))
    add(RoomModel("Double bed room", "Experience unparalleled comfort and sophistication in our double bedroom suite at The Flamingo Hotel:spacious retreat,luxurious furnishings,panoramic nature views and modern amenities.",R.drawable.db))
    add(RoomModel("Junior Suite", "Indulge in luxury at our Junior Suite in The Flamingo Hotel:chic and ambient decor,nature views which will all ensure a sophisticated memomarable stay.",R.drawable.js))
    add(RoomModel("Executive Suite","Immerse yourself in unmatched luxury at The Flamingo Hotel's Executive Suite:where grandeur,refinement,panoramic nature viewsand lavishness converge to create an unforgettable retreat.",R.drawable.es))
    add(RoomModel("Presidential Suite", "Embark on an extraordinary journey of luxury and exclusivity in our Presidential suite at the illustrious The Flamingo Hotel.",R.drawable.ps))


}

@Composable
fun MyListcustom(navController:NavHostController) {
    Text(text = "Home ",
        style = TextStyle(
            color = Romancoffee,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(roomList) { model ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .clickable { navController.navigate(ROUTE_BOOKING) },
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

            ) {
                ListRow(model = model)

            }

        }
    }
    Spacer(modifier = Modifier.height(35.dp))






}

@Preview
@Composable
private fun customprev() {
    MyListcustom(rememberNavController())
}



