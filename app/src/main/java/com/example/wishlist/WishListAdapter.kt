package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private val items: List<WishlistItem>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){
        val nameTV : TextView
        val priceTV: TextView
        val linkTV: TextView

        init {
            nameTV = itemView.findViewById(R.id.itemName)
            priceTV = itemView.findViewById(R.id.itemPrice)
            linkTV = itemView.findViewById(R.id.itemLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.nameTV.text = item.name
        holder.priceTV.text = item.price
        holder.linkTV.text = item.store
    }



}