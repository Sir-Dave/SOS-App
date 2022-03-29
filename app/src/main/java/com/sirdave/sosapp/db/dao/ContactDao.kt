package com.sirdave.sosapp.db.dao

import androidx.room.*
import com.sirdave.sosapp.db.entity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts where id = :id")
    suspend fun getOneContact(id: Int): Contact?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts where name = :name")
    suspend fun findContactByName(name: String): Contact?

    @Delete
    suspend fun deleteContact(contact: Contact)
}