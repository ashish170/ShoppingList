package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItems(
    //Without a primary key , room will throw an error
    @ColumnInfo(name = "item_name")
    var name:String,
    @ColumnInfo(name = "item_Amount")
    var amt:Int
) {
    //room will automatically fill the id when set to true and hence it is not in the constructor
        @PrimaryKey(autoGenerate = true)
        var id:Int?=null
}

//DAO class tells the room how to access our database.