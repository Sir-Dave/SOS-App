package com.sirdave.sosapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sirdave.sosapp.db.dao.ContactDao
import com.sirdave.sosapp.db.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao
}