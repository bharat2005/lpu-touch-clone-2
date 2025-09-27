package com.example.lputouch.data.source

import com.example.lputouch.data.model.MyMessage

object MyMessagesList {
    fun getMyMessagesList() : List<MyMessage>{
        return listOf<MyMessage>(
            MyMessage("Room Cleaning", "Dear Student, Housekeeping of your room is scheduled for today. After Completion of work, kindly submit the rating for the quality of work done by the housekeeping staff on the following link:Click Here", "Rajindar Kaur (Sep, 13, 2025)"),
            MyMessage("Hostel Allotment","Dear Student, Your Concern Hostel Allotment has been punched with reference no.","Dr. Vishal Sharma (Sep, 12, 2025)"),
            MyMessage("RMS Ticket Number aca/Sep-25/00150 update","Dear Student, The resolution of your request/query has been provided. Check your RMS reply and give your valuable feedback/rating through the path: UMS Navigation—Relationship Management System—View Request Status","Raghav Gupta (Sep, 10, 2025)"),
        )
    }
}