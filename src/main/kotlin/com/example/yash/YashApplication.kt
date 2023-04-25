package com.example.yash

import com.example.yash.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class YashApplication{

//	@GetMapping
//	fun hi() = arrayListOf(Person(),Person(2,"Akshit","Verma"))
}

fun main(args: Array<String>) {
	runApplication<YashApplication>(*args)
}
