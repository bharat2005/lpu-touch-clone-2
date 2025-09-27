package com.example.lputouch.data.source

import com.example.lputouch.data.model.RMSCondition

object RMSConditionsList {
    fun getRMSConditionsList(): List<RMSCondition>{
        return listOf(
            RMSCondition("I have not shared my UMS password with anyone."),
            RMSCondition("I am responsible for the content typed in the query."),
            RMSCondition("I understand that necessary disciplinary action can be initiated against me if I use derogatory words or false statements against any student/faculty/staff/higher authority."),
            RMSCondition("The information I provided regarding the complaint/request is true to the best of my knowledge, and if found false/wrong, necessary disciplinary action can be initiated against me."),
            RMSCondition("I have read the policy/UMS Notification related to the concerned matter before submitting the RMS, and I am unable to find the answer related to my query."),

        )
    }
}