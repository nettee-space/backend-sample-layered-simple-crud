package me.nettee.board.repository;

import me.nettee.board.domain.Board;
import me.nettee.board.domain.type.BoardStatus;
import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface BoardQueryRepository extends JpaRepository<Board, Long> {
    // find + 아무말 + By(WHERE) + 컬럼
    Optional<BoardDetailProjection> findBoardById(Long id);

    // NOTE 지금은 Page 객체로 그냥 반환받음. (성능 매우 느림)
    //  추후: PageableExecutionUtils 사용 시: 이 메서드는 List 반환
    Page<BoardSummaryProjection> findPageByStatusIn(Collection<BoardStatus> status, Pageable pageable);
}
