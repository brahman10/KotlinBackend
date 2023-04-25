package com.example.yash.domain

import javax.persistence.*

@Entity
data class Person(
    @Id
    @SequenceGenerator(name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PERSON_SEQUENCE)
    val id: Long=1L,
    var name: String = "Yash",
    var lastName: String? = null
) {
    companion object {
        const val PERSON_SEQUENCE = "PERSON_SEQUENCE"
    }
}
