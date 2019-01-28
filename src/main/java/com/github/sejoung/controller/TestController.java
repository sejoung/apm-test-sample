package com.github.sejoung.controller;

import com.github.sejoung.domain.Board;
import com.github.sejoung.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final BoardService boardService;

    TestController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping
    public Page<Board> list(@RequestParam(name = "page", defaultValue = "0", required = false) int page, @RequestParam(name = "pagesize", defaultValue = "10", required = false) int pagesize){
        return boardService.list(PageRequest.of(page, pagesize, Sort.Direction.DESC, "id"));
    }

}
