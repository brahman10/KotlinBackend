package com.example.yash.dao

import com.example.yash.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonDao : JpaRepository<Person,Long>