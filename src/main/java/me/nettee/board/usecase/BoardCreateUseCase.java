package me.nettee.board.usecase;

import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.domain.Board;

public interface BoardCreateUseCase {
    // Base method
    Board create(Board board);

    // Extended method
    Board create(BoardCreateRequest request);
}
