package com.sirdave.sosapp.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirdave.sosapp.db.entity.Contact
import com.sirdave.sosapp.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val repository: ContactRepository) : ViewModel() {

    private val _contact : MutableLiveData<Contact> = MutableLiveData()
    private val contact : LiveData<Contact> get() = _contact

    fun getContactById(id: Int){
        viewModelScope.launch {
            getOneContact(id)
        }
    }

    private suspend fun getOneContact(id: Int){
        val result = repository.getOneContact(id)
        _contact.value = result
    }

    fun addNewContact(contact: Contact) = viewModelScope.launch {
        repository.addNewContact(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        repository.updateContact(contact)
    }

    fun findContactByName(name: String): Contact? = runBlocking {
        return@runBlocking repository.findContactByName(name)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        repository.deleteContact(contact)
    }

    fun isContactExists(name: String): Boolean = runBlocking {
        val isExists = repository.findContactByName(name)
        return@runBlocking isExists != null
    }
}