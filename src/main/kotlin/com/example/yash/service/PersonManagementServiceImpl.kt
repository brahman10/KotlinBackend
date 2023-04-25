package com.example.yash.service

import com.example.yash.dao.PersonDao
import com.example.yash.dto.AddPersonRequest
import com.example.yash.dto.PersonResponse
import com.example.yash.dto.UpdatePersonRequest
import com.example.yash.transformer.AddPersonRequestTransform
import com.example.yash.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao, private val transform: AddPersonRequestTransform) : PersonManagementService {
    override fun addPerson(addPersonDTO: AddPersonRequest): List<PersonResponse> {
        personDao.save(transform.transform(addPersonDTO))
        return personDao.findAll().map { it.toPersonResponse()!! }
    }

    override fun getAllPerson(): List<PersonResponse> {
        return personDao.findAll().map { it.toPersonResponse()!! }
    }

    override fun updatePerson(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = personDao.findByIdOrNull(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")
        person.apply {
            lastName = updatePersonRequest.lastName
            name = updatePersonRequest.name
        }
        return personDao.save(person).toPersonResponse()!!
    }

    override fun getPersonById(id: Long): PersonResponse? {
        return personDao.findByIdOrNull(id).toPersonResponse()
    }

    override fun deleteById(id: Long) {
        personDao.deleteById(id)
    }
}