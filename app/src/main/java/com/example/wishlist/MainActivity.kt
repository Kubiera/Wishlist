package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items : MutableList<WishlistItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRV = findViewById<RecyclerView>(R.id.wishlistRV)
        val itemNameInput = findViewById<EditText>(R.id.itemNameInput)
        val itemPriceInput = findViewById<EditText>(R.id.itemPriceInput)
        val itemLinkInput = findViewById<EditText>(R.id.itemLinkInput)

        items = ArrayList()
        val adapter = WishListAdapter(items)
        wishListRV.adapter = adapter
        wishListRV.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.AddItemButton).setOnClickListener {
            val itemName = itemNameInput.text.toString()
            val itemPrice = itemPriceInput.text.toString()
            val itemLink = itemLinkInput.text.toString()
            val item = WishlistItem(itemName, itemPrice, itemLink)
            items.add(item)
            adapter.notifyDataSetChanged()
        }
    }
}