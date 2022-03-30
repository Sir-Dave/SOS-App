package com.sirdave.sosapp.di

import com.sirdave.sosapp.db.dao.ContactDao
import com.sirdave.sosapp.network.ContactService
import com.sirdave.sosapp.repository.ContactRepository
import com.sirdave.sosapp.repository.ContactRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideContactRepository(contactDao: ContactDao, service: ContactService):
            ContactRepository{
        return ContactRepositoryImpl(contactDao, service)
    }
}