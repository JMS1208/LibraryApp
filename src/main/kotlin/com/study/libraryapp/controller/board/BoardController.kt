package com.study.libraryapp.controller.board

import com.study.libraryapp.dto.board.BoardDTO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/board")
class BoardController {

    @GetMapping("/save")
    fun saveForm(): String {
        return "save"
    }

    @PostMapping("/save")
    fun save(@ModelAttribute boardDTO: BoardDTO): String {
        return ""
    }
}