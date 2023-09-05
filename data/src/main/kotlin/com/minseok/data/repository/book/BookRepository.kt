package com.minseok.data.repository.book

import com.minseok.data.entity.book.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookRepository : JpaRepository<Book, Long> {
    fun findByName(bookName: String): Optional<Book>
}