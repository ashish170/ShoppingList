package com.example.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItems
import com.example.shoppinglist.data.repo.ShoppingRepo
import com.example.shoppinglist.other.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database=ShoppingDatabase(this)
        val repo=ShoppingRepo(database)
        val factory=ShopViewModelFactory(repo)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter= ListAdapter(listOf(),viewModel)

        rvItems.layoutManager=LinearLayoutManager(this)
        rvItems.adapter=adapter

        viewModel.getitems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            ShoppingDialog(
                this, object : AddDialog {
                    override fun onAddClick(item: ShoppingItems) {
                        viewModel.upsert(item)
                    }

                }
            ).show()
        }




    }
}