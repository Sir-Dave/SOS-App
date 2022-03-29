package com.sirdave.sosapp.ui.contact_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirdave.sosapp.R
import com.sirdave.sosapp.db.entity.Contact
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: ContactListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.contact_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.contact_recycler_view)

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