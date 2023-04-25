package com.example.yash.dto

data class AddPersonRequest(
    val name:String,
    val lastName:String
)

data class UpdatePersonRequest(
    val id: Long,
    val name:String,
    val lastName:String?=null
)


data class PersonResponse(
    val id: Long,
    val fullName:String
)
