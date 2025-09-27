package com.example.lputouch.data.source

import com.example.lputouch.data.model.TileOption
import com.example.lputouch.R
object TileOptionsList {
    fun getTileOptionsList() : List<TileOption>{
        return listOf(
            TileOption("Announce", value = "0", R.drawable.announce),
            TileOption("Edu Revolution", value = "0",R.drawable.edu),
            TileOption("Fee Statement", value = "", image = R.drawable.fee),
            TileOption("Attendance", value = "75%", R.drawable.attendence),
            TileOption("Assignment", value = "0", R.drawable.assingment),
            TileOption("Results", value = "2.00", R.drawable.results),
            TileOption("Exams", value = "4", R.drawable.results),
            TileOption("RMS Status", value = "", image = R.drawable.exam),
            TileOption("Events",value = "", image = R.drawable.events),
            TileOption("10 to Thrive", value = "0", image = R.drawable.thrive),
            TileOption("Back to Basics", value = "2", image = R.drawable.basics),
            TileOption("Mess Food Scanner", value = "X", image = R.drawable.general),
            TileOption("Time table", value = "X", image = R.drawable.general),
        )
    }
}