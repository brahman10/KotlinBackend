package com.example.yash.resource

import com.example.yash.dto.AddPersonRequest
import com.example.yash.dto.PersonResponse
import com.example.yash.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

interface PersonResource {

    fun addPerson(addPersonDTO: AddPersonRequest):ResponseEntity<List<PersonResponse>>

    fun getAllPerson():ResponseEntity<List<PersonResponse>>

    fun updatePerson(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>

    fun getPersonById(id:Long): ResponseEntity<PersonResponse?>

    fun deleteById(id:Long):ResponseEntity<Unit>
}