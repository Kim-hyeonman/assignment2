package com.example.assignment2.model

data class Clothes(
    val part: Int,
    val partName : String,
    val status: OnoffStatus = OnoffStatus.OFF
)