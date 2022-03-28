package com.sirdave.sosapp.contact

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sirdave.sosapp.R

class ContactFragment : Fragment() {
    private lateinit var addNewContact: EditText
    private lateinit var displayContact: EditText
    private lateinit var btnSave : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.contact_fragment, container, false)

        addNewContact = view.findViewById(R.id.contactName)
        displayContact = view.findViewById(R.id.contactPhone)
        btnSave = view.findViewById(R.id.btnSave)


        btnSave.setOnClickListener {
            saveToDB(requireContext())
        }

        return view
    }

    private fun saveToDB(context: Context){
        if (isEmpty(addNewContact) || isEmpty(displayContact)){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }
        else{
            //TODO: Save the contact to DB
        }
    }

    private fun isEmpty(editText: EditText): Boolean{
        return editText.text.toString() == ""
    }
}