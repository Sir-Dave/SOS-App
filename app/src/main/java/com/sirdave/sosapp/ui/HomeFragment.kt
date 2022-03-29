package com.sirdave.sosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import com.sirdave.sosapp.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val addNewContact : Button = view.findViewById(R.id.addContact)
        val displayContact: Button = view.findViewById(R.id.displayContact)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        imageView.setOnClickListener{
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.openCamera)
        }

        addNewContact.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.newContact)
        }

        displayContact.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.viewContactList)
        }

        return view
    }
}