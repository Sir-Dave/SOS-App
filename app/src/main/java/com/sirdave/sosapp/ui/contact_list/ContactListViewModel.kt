package com.sirdave.sosapp.ui.contact_list

import androidx.lifecycle.*
import com.sirdave.sosapp.db.entity.Contact
import com.sirdave.sosapp.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactListViewModel @Inject constructor(
    private val repository: ContactRepository): ViewModel() {

    var contacts: LiveData<List<Contact>> = MutableLiveData()

    init {
        getAllContacts()
    }

    private fun getAllContacts(){
        viewModelScope.launch {
            val results = repository.getAllContacts()
            contacts = results.asLiveData()
        }
    }
}