package com.example.yash.service

import com.example.yash.dto.AddPersonRequest
import com.example.yash.dto.PersonResponse
import com.example.yash.dto.UpdatePersonRequest

interface PersonManagementService {

    fun addPerson(addPersonDTO: AddPersonRequest):List<PersonResponse>

    fun getAllPerson():List<PersonResponse>

    fun updatePerson(updatePersonRequest: UpdatePersonRequest):PersonResponse

    fun getPersonById(id:Long):PersonResponse?

    fun deleteById(id:Long)
}