package com.study.libraryapp.controller.board

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Controller
class HomeController {

    @GetMapping("/")
    fun index(): String {
        return "index.html"
    }

}