package com.example.lputouch.data.source

import com.example.lputouch.data.model.MessDetail

object MessDetailList {
    fun getMessDetilsList(): List<MessDetail> {
        return listOf(
            MessDetail("Father's Name", "Deshmukh Vasanta (8888241563)"),
            MessDetail("Mother's Name", "Pushpa (+91-7499286521)"),
            MessDetail("Program Name", "P132: B.Tech. (Computer Science and Engineering) (2024)"),
            MessDetail("Hostel", "null"),
        )
    }

    fun getSuccessMessDetilsList(): List<MessDetail> {
        return listOf(
            MessDetail("Father's Name", "Deshmukh Vasanta (8888241563)"),
            MessDetail("Mother's Name", "Pushpa (+91-7499286521)"),
            MessDetail("Session", "P132: B.Tech. (Computer Science and Engineering) (2024)"),
            MessDetail("Hostel", "null"),
        )
    }
}