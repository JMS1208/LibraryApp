package com.study.libraryapp.domain.book

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 255, name = "name")
    @field:NotBlank(message = "잘못된 이름입니다")
    val name: String? = null,
)
