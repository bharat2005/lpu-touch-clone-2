package com.example.lputouch.data.local

import android.content.Context
import androidx.compose.ui.layout.Placeable
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore("my_prefs")

val HOSTEL = stringPreferencesKey("hostel")
val PLAINTEXT = stringPreferencesKey("plaintext")
val MESS_CODE = stringPreferencesKey("mess_code")
val MESS_NAME = stringPreferencesKey("mess_name")

suspend fun saveMyDetails(context: Context, key: String, value : String){
    context.dataStore.edit { prefs ->
        prefs[stringPreferencesKey(key)] = value
    }
}

fun getMyDetails(context: Context, key: String) : Flow<String?> {
   return context.dataStore.data.map { prefs ->
        prefs[stringPreferencesKey(key)]
    }}
