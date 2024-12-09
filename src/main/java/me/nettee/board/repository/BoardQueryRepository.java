package me.nettee.board.repository;

import me.nettee.board.domain.Board;
import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardQueryRepository extends JpaRepository<Board, Long> {
    Optional<BoardDetailProjection> findBoardById(Long id);

    List<BoardSummaryProjection> findBoardsBy(Pageable pageable);
}
