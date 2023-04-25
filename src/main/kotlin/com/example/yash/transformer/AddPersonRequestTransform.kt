package com.example.yash.transformer

import com.example.yash.domain.Person
import com.example.yash.dto.AddPersonRequest
import com.example.yash.dto.PersonResponse
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransform:Transformer<AddPersonRequest,Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName= source.lastName
        )
    }
}

fun Person?.toPersonResponse():PersonResponse?{
    return this?.let {
        PersonResponse(
            id= this.id,
            fullName = "${this.name} ${this.lastName}")
    }
}
