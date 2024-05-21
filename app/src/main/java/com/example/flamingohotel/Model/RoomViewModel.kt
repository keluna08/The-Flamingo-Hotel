package com.example.flamingohotel.Model

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.flamingohotel.Data.Room
import com.example.flamingohotel.Navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase



class RoomViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveRoom(
        name: String,
        email: String,
        RoomType: String,
        CheckIn: String,
        CheckOut: String,

    ) {
        var id = System.currentTimeMillis().toString()
        var RoomData = Room(name, email, RoomType, CheckIn, CheckOut, id)
        var RoomRef = FirebaseDatabase.getInstance().getReference()
            .child("Rooms/$id")
        progress.show()
        RoomRef.setValue(RoomData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
