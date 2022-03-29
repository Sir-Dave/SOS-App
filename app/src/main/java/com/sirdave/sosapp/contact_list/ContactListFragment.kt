package com.sirdave.sosapp.contact_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.sosapp.R
import com.sirdave.sosapp.contact.model.Contact

class ContactListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: ContactListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.contact_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.contact_recycler_view)


        return view
    }

    private fun setUpRecyclerView(contactList: List<Contact>){
        val context = requireContext()
        val adapter = ContactRecyclerAdapter(context, contactList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

}