package com.study.libraryapp.domain.book

import com.study.libraryapp.domain.book.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

interface BookRepository : JpaRepository<Book, Long> {
    fun findByName(bookName: String): Optional<Book>
}