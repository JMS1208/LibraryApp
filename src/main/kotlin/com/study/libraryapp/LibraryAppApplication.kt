package com.study.libraryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.minseok.domain", "com.minseok.data", "com.minseok.presentation"])
class LibraryAppApplication

fun main(args: Array<String>) {
	runApplication<LibraryAppApplication>(*args)
}
