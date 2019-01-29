package com.github.sejoung.service;

import com.github.sejoung.domain.Board;
import com.github.sejoung.param.BoardParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void createBorad(){

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
    public void detail(){

        BoardParam bp = new BoardParam();
        bp.setBoardId(1L);
        var boardOptional = boardService.detail(bp);


        boardOptional.ifPresent(System.out::println);

    }

}
