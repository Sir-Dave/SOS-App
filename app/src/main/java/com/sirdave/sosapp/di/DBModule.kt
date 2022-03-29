package com.sirdave.sosapp.di

import android.content.Context
import androidx.room.Room
import com.sirdave.sosapp.db.AppDatabase
import com.sirdave.sosapp.db.dao.ContactDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val APP_DATABASE = "contact_db"

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Singleton
    @Provides
    fun provideContactDao(db: AppDatabase): ContactDao{
        return db.contactDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context,
            AppDatabase::class.java,
            APP_DATABASE)
            .build()
    }
}