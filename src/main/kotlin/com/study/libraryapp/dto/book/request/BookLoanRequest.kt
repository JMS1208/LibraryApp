package com.study.libraryapp.dto.book.request

data class BookLoanRequest(
    val userName: String,
    val bookName: String
)