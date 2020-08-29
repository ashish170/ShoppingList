package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItems
import kotlinx.android.synthetic.main.dialog_new.*

class ShoppingDialog(context: Context,var addDialog: AddDialog): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_new)

        tvAdd.setOnClickListener {
            val name= etName.text.toString()
            val amt= etAmt.text.toString()
            if(name.isEmpty() || amt.isEmpty())
            {
                Toast.makeText(context,"InVALID",Toast.LENGTH_LONG).show()

                return@setOnClickListener

            }
            val item=ShoppingItems(name,amt.toInt())
            addDialog.onAddClick(item)
            dismiss()

        }
        tvCancel.setOnClickListener {
            cancel()
        }

    }

}