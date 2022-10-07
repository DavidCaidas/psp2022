package com.davidcai.psp.ut02.ex02.domain

import retrofit2.http.Body
import java.util.Date

data class Alert(val id: String, val alert_id: String, val title: String,val type: String,val date: Date,val summary: String,val body: Body? ,val source: String,val files:String)

