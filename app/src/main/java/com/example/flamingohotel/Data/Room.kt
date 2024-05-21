package com.example.flamingohotel.Data

class Room {
    var name:String=""
    var email:String=""
    var RoomType:String=""
    var CheckIn:String=""
    var CheckOut:String=""
    var id:String=""


    constructor(name:String,email:String,RoomType:String,CheckIn:String,CheckOut:String,id:String){
        this.name=name
        this.email=email
        this.RoomType=RoomType
        this.CheckIn=CheckIn
        this.CheckOut=CheckOut
        this.id=id
    }
    constructor()
}
