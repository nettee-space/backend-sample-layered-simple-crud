package me.nettee.board.usecase;

import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;

public interface BoardSelectOneUseCase {
    BoardDetailProjection findById(Long id);
}
