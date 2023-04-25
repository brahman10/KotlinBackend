package com.example.yash.resource

import com.example.yash.dto.AddPersonRequest
import com.example.yash.dto.PersonResponse
import com.example.yash.dto.UpdatePersonRequest
import com.example.yash.resource.PersonResourceImpl.Companion.BASE_URL
import com.example.yash.service.PersonManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [BASE_URL])
class PersonResourceImpl(private val personManagementService: PersonManagementService) : PersonResource {

    companion object{
        const val BASE_URL = "/api/v1/person"
    }

    @PostMapping
    override fun addPerson(@RequestBody addPersonDTO: AddPersonRequest): ResponseEntity<List<PersonResponse>> {
        val person = personManagementService.addPerson(addPersonDTO)
        return ResponseEntity.ok(person)
    }

    @GetMapping
    override fun getAllPerson(): ResponseEntity<List<PersonResponse>> = ResponseEntity.ok(personManagementService.getAllPerson())

    @PutMapping
    override fun updatePerson(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> = ResponseEntity.ok(personManagementService.updatePerson(updatePersonRequest))

    @GetMapping("/{id}")
    override fun getPersonById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        return ResponseEntity.ok(personManagementService.getPersonById(id))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        personManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}