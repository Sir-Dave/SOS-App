package com.sirdave.sosapp.repository

import com.sirdave.sosapp.db.entity.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun getAllContacts(): Flow<List<Contact>>

    suspend fun getOneContact(id: Int): Contact?

    suspend fun addNewContact(contact: Contact)

    suspend fun updateContact(contact: Contact)

    suspend fun findContactByName(name: String): Contact?

    suspend fun deleteContact(contact: Contact)
}