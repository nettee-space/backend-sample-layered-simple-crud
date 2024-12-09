package me.nettee.board.usecase;

import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardSelectAllUseCase {
    List<BoardSummaryProjection> findAllBy(Pageable pageable);
}
