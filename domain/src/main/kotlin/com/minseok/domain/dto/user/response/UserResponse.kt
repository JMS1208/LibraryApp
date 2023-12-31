package com.study.libraryapp.dto.user.response

import com.minseok.data.entity.user.User

data class UserResponse(
    val id: Long,
    val name: String?,
    val age: Int?
) {
    constructor(user: User): this(user.id!!, user.name, user.age)
}