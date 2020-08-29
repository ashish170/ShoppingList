package com.example.shoppinglist.data.repo

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItems

class ShoppingRepo(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(items: ShoppingItems)=db.getDao().upsert(items)


    suspend fun delete(items: ShoppingItems)=db.getDao().delete(items)

     fun getDao()=db.getDao().getItems()
}