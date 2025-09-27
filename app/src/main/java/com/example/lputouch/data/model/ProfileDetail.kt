package com.example.lputouch.data.model

data class ProfileDetail(
    val sectionName : String,
    val detailList : List<ProfileDots>
)

data class ProfileDots(
    val name : String,
    val value : String
)
