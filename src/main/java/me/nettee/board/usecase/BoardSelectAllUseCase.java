package me.nettee.board.usecase;

import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSelectAllUseCase {
    Page<BoardSummaryProjection> findGeneralBy(Pageable pageable);
}
