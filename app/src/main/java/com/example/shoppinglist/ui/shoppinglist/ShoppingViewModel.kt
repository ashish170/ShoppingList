package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.entities.ShoppingItems
import com.example.shoppinglist.data.repo.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repo: ShoppingRepo
):ViewModel() {

    fun upsert(items: ShoppingItems)=CoroutineScope(Dispatchers.Main).launch {
        repo.upsert(items)
    }
    fun delete(items: ShoppingItems)= CoroutineScope(Dispatchers.Main).launch {
        repo.delete(items)
    }
     fun getitems()= repo.getDao()
}