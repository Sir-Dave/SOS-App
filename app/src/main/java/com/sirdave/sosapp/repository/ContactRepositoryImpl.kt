package com.sirdave.sosapp.repository

import com.sirdave.sosapp.db.dao.ContactDao
import com.sirdave.sosapp.db.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val contactDao: ContactDao): ContactRepository {
    override fun getAllContacts(): Flow<List<ContactEntity>> {
        return contactDao.getAllContacts()
    }

    override suspend fun getOneContact(id: Int): ContactEntity? {
        return contactDao.getOneContact(id)
    }

    override suspend fun addNewContact(contact: ContactEntity){
        contactDao.addNewContact(contact)
    }

    override suspend fun deleteContact(contact: ContactEntity) {
        return contactDao.deleteContact(contact)
    }
}