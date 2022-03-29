package com.sirdave.sosapp.ui.contact

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.sirdave.sosapp.R
import com.sirdave.sosapp.db.entity.Contact
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment() {
    private lateinit var contactName: EditText
    private lateinit var contactPhone: EditText
    private lateinit var btnSave : Button
    private val viewModel: ContactViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.contact_fragment, container, false)

        contactName = view.findViewById(R.id.contactName)
        contactPhone = view.findViewById(R.id.contactPhone)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            saveToDB(requireContext(), it)
        }

        return view
    }

    private fun saveToDB(context: Context, view: View){
        if (isEmpty(contactName) || isEmpty(contactPhone)){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }
        else{
            createOrUpdateContact(view)
        }
    }

    private fun createOrUpdateContact(view: View){
        val name = contactName.text.toString()
        val phoneNumber = contactPhone.text.toString()
        if (viewModel.isContactExists(name)){
            val contact = viewModel.findContactByName(name)
            contact?.name = name
            contact?.phoneNumber = phoneNumber
            viewModel.updateContact(contact!!)
        }
        else{
            val newContact = Contact(name, phoneNumber)
            viewModel.addNewContact(newContact)
        }
        Toast.makeText(context, "Successfully saved contact",
            Toast.LENGTH_SHORT).show()

        val navController = Navigation.findNavController(view)
        navController.popBackStack()
    }

    private fun isEmpty(editText: EditText): Boolean{
        return editText.text.toString() == ""
    }
}