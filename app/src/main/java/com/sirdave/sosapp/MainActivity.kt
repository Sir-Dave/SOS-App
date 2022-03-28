package com.sirdave.sosapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sirdave.sosapp.contact.ContactFragment
import com.sirdave.sosapp.contact_list.ContactListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addNewContact : Button = findViewById(R.id.addContact)
        val displayContact: Button = findViewById(R.id.displayContact)

        val contactFragment = ContactFragment()
        val contactListFragment = ContactListFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        addNewContact.setOnClickListener {
            transaction.add(R.id.container_home, contactFragment, "contactFragment")
            transaction.commit()
        }

        displayContact.setOnClickListener {
            transaction.add(R.id.container_home, contactListFragment, "contactListFragment")
            transaction.commit()
        }
    }
}