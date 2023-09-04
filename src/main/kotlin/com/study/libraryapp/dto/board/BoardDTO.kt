package com.study.libraryapp.dto.board

import org.hibernate.annotations.GeneratorType
import java.time.LocalDateTime
import jakarta.persistence.Id


data class BoardDTO(
    val id: Long,
    val writer: String,
    val password: String,
    val title: String,
    val contents: String,
    val hits: Int,
    val createdTime: LocalDateTime,
    val updatedTime: LocalDateTime
)
