package com.sirdave.sosapp.ui

import androidx.lifecycle.*
import com.sirdave.sosapp.db.entity.Contact
import com.sirdave.sosapp.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val repository: ContactRepository) : ViewModel() {

    private val _oneContact: MutableLiveData<Contact> = MutableLiveData()
    val oneContact: LiveData<Contact> get() = _oneContact
    var contacts: LiveData<List<Contact>> = MutableLiveData()

    init {
        getAllContacts()
    }

    fun getContactById(id: Int){
        viewModelScope.launch {
            getOneContact(id)
        }
    }

    private fun getAllContacts(){
        viewModelScope.launch {
            val results = repository.getAllContacts()
            contacts = results.asLiveData()
        }
    }

    private suspend fun getOneContact(id: Int){
        val result = repository.getOneContact(id)
        _oneContact.value = result
    }

    fun addNewContact(contact: Contact) = viewModelScope.launch {
        repository.addNewContact(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        repository.updateContact(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        repository.deleteContact(contact)
    }

}