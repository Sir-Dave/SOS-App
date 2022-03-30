package com.sirdave.sosapp.repository

import com.sirdave.sosapp.db.dao.ContactDao
import com.sirdave.sosapp.db.entity.Contact
import com.sirdave.sosapp.network.Request
import com.sirdave.sosapp.network.Response
import com.sirdave.sosapp.network.ContactService
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val contactDao: ContactDao,
                            private val contactService: ContactService): ContactRepository {
    override fun getAllContacts(): Flow<List<Contact>> {
        return contactDao.getAllContacts()
    }

    override suspend fun getOneContact(id: Int): Contact? {
        return contactDao.getOneContact(id)
    }

    override suspend fun addNewContact(contact: Contact){
        contactDao.addNewContact(contact)
    }

    override suspend fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    override suspend fun findContactByName(name: String): Contact? {
        return contactDao.findContactByName(name)
    }

    override suspend fun deleteContact(contact: Contact) {
        return contactDao.deleteContact(contact)
    }

    override suspend fun sendRequest(request: Request): Response {
        return contactService.submitRequest(request)
    }
}