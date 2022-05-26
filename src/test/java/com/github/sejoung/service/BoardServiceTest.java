package com.github.sejoung.service;

import com.github.sejoung.domain.Board;
import com.github.sejoung.param.BoardParam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void createBorad(){

        BoardParam bp = new BoardParam();
        bp.setBoardId(0L);
        bp.setBoardTitle("1234title");
        bp.setBoardContents("1234");
        Board b = boardService.save(bp);
        assertThat("1234title").isEqualTo(b.getTitle());
        assertThat("1234").isEqualTo(b.getContents());
        assertThat(0).isZero();
    }

    @Test
    void detail(){

        BoardParam bp = new BoardParam();
        bp.setBoardId(1L);
        var boardOptional = boardService.detail(bp);

        assertThat(boardOptional).isEmpty();
        boardOptional.ifPresent(System.out::println);

    }

}
