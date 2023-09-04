package com.study.libraryapp.controller.board

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/board")
class BoardController {

    @GetMapping("/save")
    fun saveForm(): String {
        return "save"
    }
}