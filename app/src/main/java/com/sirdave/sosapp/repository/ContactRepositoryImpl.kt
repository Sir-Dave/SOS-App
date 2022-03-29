package com.sirdave.sosapp.repository

import com.sirdave.sosapp.db.dao.ContactDao
import com.sirdave.sosapp.db.entity.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val contactDao: ContactDao): ContactRepository {
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
}