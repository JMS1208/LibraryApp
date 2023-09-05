package com.study.libraryapp

import com.study.libraryapp.dto.user.response.UserResponse
import com.study.libraryapp.service.user.UserService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(scanBasePackages = ["com.minseok.data", "com.minseok.domain", "com.minseok.presentation", "com.study"])
class LibraryAppApplication

fun main(args: Array<String>) {
	val context = runApplication<LibraryAppApplication>(*args)

	val beans = context.beanDefinitionNames
	beans.sort()
	println("Registered Beans:")
	for (bean in beans) {
		println("빈: $bean")
	}
}
