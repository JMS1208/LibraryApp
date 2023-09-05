package com.study.libraryapp.controller.book

import com.study.libraryapp.dto.book.request.BookCreateRequest
import com.study.libraryapp.dto.book.request.BookLoanRequest
import com.study.libraryapp.dto.book.request.BookReturnRequest
import com.study.libraryapp.service.book.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val service: BookService
) {

    @PostMapping("/book")
    fun saveBook(@RequestBody request: BookCreateRequest) {
        service.saveBook(request)
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody request: BookLoanRequest) {
        service.loanBook(request)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody request: BookReturnRequest) {
        service.returnBook(request)
    }

}