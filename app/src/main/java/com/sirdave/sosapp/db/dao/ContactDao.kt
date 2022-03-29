package com.sirdave.sosapp.db.dao

import androidx.room.*
import com.sirdave.sosapp.db.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM contacts where id = :id")
    suspend fun getOneContact(id: Int): ContactEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewContact(contactEntity: ContactEntity): ContactEntity?

    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)
}