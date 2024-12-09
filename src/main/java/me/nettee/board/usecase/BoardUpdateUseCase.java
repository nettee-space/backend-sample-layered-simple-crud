package me.nettee.board.usecase;

import me.nettee.board.domain.Board;

public interface BoardUpdateUseCase {
    Board update(Long id, String title, String content);
}
