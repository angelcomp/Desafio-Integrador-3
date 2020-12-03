package com.example.desafiointegrador3.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiointegrador3.services.Service
import com.example.desafiointegrador3.utils.Comic
import kotlinx.coroutines.launch

class MainViewModel(val service: Service): ViewModel() {
    var lista = MutableLiveData<Comic>()

    fun popList() {

        viewModelScope.launch {
            lista.value = service.getComics(
                "1",
                "f28a07f38dc7090aa24b3e50496e6ac6",
                "f7aece34f231420e8d8fb2e698fa4113"
            )
        }
    }
}

//ts=1
// apikey=f28a07f38dc7090aa24b3e50496e6ac6
// hash=f7aece34f231420e8d8fb2e698fa4113