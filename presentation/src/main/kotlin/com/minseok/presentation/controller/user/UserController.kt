package com.study.libraryapp.controller.user

import com.study.libraryapp.dto.user.request.UserCreateRequest
import com.study.libraryapp.dto.user.request.UserUpdateRequest
import com.study.libraryapp.dto.user.response.UserResponse
import com.study.libraryapp.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

/*
진입점으로 만들어 주기도 하고
스프링 빈으로 등록도 시켜줌
 */
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/user")
    fun saveUser(
        @RequestBody request: UserCreateRequest
    ) {

        userService.saveUser(request)
    }

    @GetMapping("/user")
    fun getUsers(): List<UserResponse> {
        println("테스트!!!!!!!!!!!!!")
        return userService.getUsers()
    }

    @PutMapping("/user")
    fun updateUser(
        @RequestBody request: UserUpdateRequest
    ) {
        userService.updateUser(request)
    }

    @DeleteMapping("/user")
    fun deleteUser(
        @RequestParam name: String
    ) {
        /*
        해당 유저가 존재하는지 먼저 조회
         */
        userService.deleteUser(name)
    }

}