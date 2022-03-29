package com.sirdave.sosapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "contacts",
    indices = [Index(value = ["name", "phoneNumber"], unique = true)])

data class Contact(
    @ColumnInfo (name = "name") var name: String?,
    @ColumnInfo(name = "phoneNumber") var phoneNumber: String?
){
    @PrimaryKey (autoGenerate = true) var id: Int? = null
}