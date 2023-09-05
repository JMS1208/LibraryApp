package com.study.libraryapp.dto.board

import java.time.LocalDateTime


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
