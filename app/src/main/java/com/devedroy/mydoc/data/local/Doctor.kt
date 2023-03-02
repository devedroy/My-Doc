package com.devedroy.mydoc.data.local

import java.sql.Time

class Doctor(
    val name: String,
    val qualification: String,
    val specialization: String,
    val arriveTime: Time,
    val departTime: Time,
)
