package com.github.sejoung.service;


import com.github.sejoung.domain.Board;
import com.github.sejoung.param.BoardParam;
import com.github.sejoung.repositories.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;

@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;

    }

    public Board save(BoardParam boardParam) {

        var bdOptional = boardRepository.findById(boardParam.getBoardId());
        Supplier<Board> boardSupplier = Board::new;
        var board = bdOptional.orElseGet(boardSupplier);

        board.setTitle(boardParam.getBoardTitle());
        board.setContents(boardParam.getBoardContents());
        if (board.getHit() > 0) {
            board.setHit(board.getHit());
        }

        return boardRepository.save(board);
    }

    public Optional<Board> detail(BoardParam boardParam) {
        var bdOptional = boardRepository.findById(boardParam.getBoardId());

        bdOptional.ifPresent(board -> {
            board.setHit(board.getHit() + 1);
            boardRepository.save(board);
        });

        return bdOptional;
    }


    public Page<Board> list(Pageable pageable) {


        return boardRepository.findAll(pageable);
    }


}
