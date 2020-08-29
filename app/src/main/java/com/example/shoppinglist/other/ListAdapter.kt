package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItems
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ListAdapter(
    var items:List<ShoppingItems>,
    private val viewMod: ShoppingViewModel
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {



    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curItem= items[position]
        holder.itemView.tvName.text=curItem.name
        holder.itemView.tvAmount.text="${curItem.amt}"

        holder.itemView.delete.setOnClickListener {
            viewMod.delete(curItem)
        }

        holder.itemView.add.setOnClickListener {
            curItem.amt++
            viewMod.upsert(curItem)
        }

        holder.itemView.minus.setOnClickListener {
            if(curItem.amt>0)
            {
                curItem.amt--
                viewMod.upsert(curItem)
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}