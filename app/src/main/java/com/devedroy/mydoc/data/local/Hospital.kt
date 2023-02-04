package com.devedroy.mydoc.data.local


data class Hospital(
    val name: String,
    val departments: List<Department>,
    val surgeries: List<Surgery>,
    val tests: List<Test>,
    val address: String,
    val rating: Float
)
