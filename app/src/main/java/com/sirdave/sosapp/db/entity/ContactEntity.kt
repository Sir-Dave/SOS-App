package com.sirdave.sosapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phoneNumber") val phoneNumber: String?
)