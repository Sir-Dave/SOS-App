package com.sirdave.sosapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.sosapp.R
import com.sirdave.sosapp.db.entity.Contact
import com.sirdave.sosapp.ui.ContactRecyclerAdapter
import com.sirdave.sosapp.ui.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ContactListFragment : Fragment() {

    private lateinit var addContactIcon: ImageView
    private lateinit var recyclerView: RecyclerView
    private val viewModel: ContactViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.contact_list_fragment, container, false)

        (requireActivity() as AppCompatActivity?)!!.supportActionBar!!.hide()

        addContactIcon = view.findViewById(R.id.addContactIcon)
        recyclerView = view.findViewById(R.id.contact_recycler_view)

        addContactIcon.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.newContact)
        }

        viewModel.contacts.observe(viewLifecycleOwner, { contacts ->
            setUpRecyclerView(contacts)
        })

        return view
    }

    private fun setUpRecyclerView(contactList: List<Contact>){
        val context = requireContext()
        val adapter = ContactRecyclerAdapter(context, contactList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
    }

}