package com.sirdave.sosapp.repository

import com.sirdave.sosapp.db.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun getAllContacts(): Flow<List<ContactEntity>>

    suspend fun getOneContact(id: Int): ContactEntity?

    suspend fun addNewContact(contact: ContactEntity): ContactEntity?

    suspend fun deleteContact(contact: ContactEntity)
}