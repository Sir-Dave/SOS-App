package com.sirdave.sosapp.ui.contact_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        holder.phone.text = contact.phoneNumber
        holder.imageIcon.text = contact.name?.substring(0, 1)
        holder.parent.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(Constants.CONTACT_ID, contact.id!!)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.viewContact, bundle)
        }
    }

    override fun getItemCount(): Int = contactList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.txt_character_name)
        var phone: TextView = itemView.findViewById(R.id.txt_character_phone)
        var imageIcon: TextView = itemView.findViewById(R.id.contactIcon)
        var parent: CardView = itemView.findViewById(R.id.root_card_view)
    }
}