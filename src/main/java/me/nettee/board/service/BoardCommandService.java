package me.nettee.board.service;

import lombok.RequiredArgsConstructor;
import me.nettee.board.domain.Board;
import me.nettee.board.repository.BoardCommandRepository;
import me.nettee.board.usecase.BoardCreateUseCase;
import me.nettee.board.usecase.BoardDeleteUseCase;
import me.nettee.board.usecase.BoardUpdateUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCommandService
        implements BoardCreateUseCase,
        BoardUpdateUseCase,
        BoardDeleteUseCase {

    private final BoardCommandRepository boardCommandRepository;

    @Override
    public Board create(Board board) {
        return boardCommandRepository.save(board);
    }

    @Override
    public Board update(Long id, String title, String content) {
        var board = boardCommandRepository
                .findById(id)
                .orElseThrow(/* TODO input exception function */);

        board.prepareUpdate()
                .title(title)
                .content(content)
                .update();

        return board;
    }

    @Override
    public void delete(Long id) {
        boardCommandRepository.deleteById(id);
    }
}
