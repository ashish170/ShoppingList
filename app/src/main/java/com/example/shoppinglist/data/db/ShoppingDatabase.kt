package com.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItems

@Database(
    entities = [ShoppingItems::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase(){

    abstract fun getDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase?=null
        private val Lock=Any()
  //whenever the instance for shopping databse is created (shoopingdatabse()), the function gets called
        operator fun invoke(context: Context)= instance ?: synchronized(Lock)
  {
      //Used to create if our instance is null.
        instance ?: getData(context).also { instance = it }
  }

        private fun getData(context: Context)=Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java
        ,"ShoppingDb.db").build()
    }

}