package com.example.lputouch

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class AppViewModal : ViewModel() {
    var messId by mutableStateOf("null")
        private set

    fun upDateMessId(id : String){
        messId = id
    }

    fun resetMessId(){
        messId = "null"

    }
}