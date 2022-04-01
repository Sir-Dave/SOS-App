package com.sirdave.sosapp.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.sosapp.Constants
import com.sirdave.sosapp.R
import com.sirdave.sosapp.db.entity.Contact

class ContactRecyclerAdapter(
    val context: Context,
    private var contactList: List<Contact>
    ): RecyclerView.Adapter<ContactRecyclerAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_contact_list, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val contact = contactList[position]
        holder.name.text = contact.name
        holder.parent.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(Constants.CONTACT_ID, contact.id!!)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.viewContact, bundle)
        }
    }

    private fun changeBackgroundColour(){
        val brown = Color.parseColor("#522323")
        val lemon = Color.parseColor("#7DA53C")
        val green = Color.parseColor("#358D92")
        val black = Color.parseColor("#000000")
        val fuschia = Color.parseColor("#AC278E")
        val colors: List<Int> = listOf(brown, lemon, green, black, fuschia)
    }

    override fun getItemCount(): Int = contactList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.txt_character_name)
        var imageIcon: ImageView = itemView.findViewById(R.id.contactIcon)
        var parent: CardView = itemView.findViewById(R.id.root_card_view)
    }
}