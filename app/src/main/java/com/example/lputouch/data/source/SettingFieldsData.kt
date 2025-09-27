package com.example.lputouch.data.source

import com.example.lputouch.data.model.SettingFeild

object SettingFieldsData {
    fun getSettinFeilds():  List<SettingFeild>{
        return listOf<SettingFeild>(
            SettingFeild("hostel", "Hostel", "Boys Hostel-09- A908-Bed D (Std Non-AC 4 Seater)"),
            SettingFeild("plaintext", "Plain Text", "BH1M07"),
            SettingFeild("mess_code", "Mess Code", "Mess-1 BH-1"),
            SettingFeild("mess_name", "Mess Name", "Mess 1"),
        )
    }
}