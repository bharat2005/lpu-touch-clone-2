package com.example.lputouch.data.source

import com.example.lputouch.R
import com.example.lputouch.data.model.Happening

object HappeningsList {
    fun getHappeningsList(): List<Happening> {
        return listOf<Happening>(
            Happening(R.drawable.image1, "LPU Secures 31st Rank Among all Government and Private Universities in India’s NIRF Rankings 2025"),
            Happening(R.drawable.image2, "Eight LPU Students Join 300+ International Scholars at Fully Funded Programs in Russia"),
            Happening(R.drawable.image3, "LPU Students Steer India to Asia Cup 2025 Hockey Triumph"),
            Happening(R.drawable.image4, "LPU Baseball Team Clinches All India Inter University Championship 2025"),
            Happening(R.drawable.image5, "MP Dr. Ashok Kumar Mittal bans American soft drinks on LPU Campus; appeals all Indians to join hands and support Swadeshi 2.0"),
            Happening(R.drawable.image6, "LPU Celebrated National Space Day 2025 in Collaboration with SAC, ISRO"),
            Happening(R.drawable.image7, "LPU Joined Hands with Noble Initiative to Provide Civil Services Training to Students through Pro Bono Initiative ‘Mission Kartavya’"),
            Happening(R.drawable.image8, "LPU Honours Young Researchers with ₹1.65 Crore in Incentives for Academic Excellence"),
            Happening(R.drawable.image9, "LPU Campus Thrills as Bollywood actress Geeta Basra and Indian actor Raj Kundra Join Freshers’ Festivities"),
            Happening(R.drawable.image10, "Historic First Open Pan Asian International Boomerang Championship at LPU Brings Participants from Five Nations"),

        )
    }
}