package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entities.ShoppingItems

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //This function is used for insertion and updating. If the new item is already inserted, it replaces.(onConflict)
   suspend fun upsert(item: ShoppingItems)

    @Delete
    suspend fun delete(item: ShoppingItems)

    //SQl does not allow us to write to the database using the main thread hence we have to call the func async'ly
    //This can be achieved by threads or co-routines in kotlin.

    @Query("SELECT * FROM shopping_items")
    fun getItems(): LiveData<List<ShoppingItems> >
}