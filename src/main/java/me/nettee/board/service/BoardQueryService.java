package me.nettee.board.service;

import lombok.RequiredArgsConstructor;
import me.nettee.board.domain.type.BoardStatus;
import me.nettee.board.exception.BoardQueryErrorCode;
import me.nettee.board.repository.BoardQueryRepository;
import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import me.nettee.board.usecase.BoardSelectAllUseCase;
import me.nettee.board.usecase.BoardSelectOneUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BoardQueryService
        implements BoardSelectOneUseCase,
        BoardSelectAllUseCase {

    private final BoardQueryRepository boardQueryRepository;

    @Override
    public BoardDetailProjection findById(Long id) {
        return boardQueryRepository.findBoardById(id)
                .orElseThrow(BoardQueryErrorCode.BOARD_NOT_FOUND::defaultException);
    }

    @Override
    public Page<BoardSummaryProjection> findGeneralBy(Pageable pageable) {
        Collection<BoardStatus> statuses = BoardStatus.getGeneralQueryStatus();

        var page = boardQueryRepository.findPageByStatusIn(statuses, pageable);
        page.map(this::hideTitleIfSuspended);

        // NOTE 지금은 그냥 페이지 조회해서 반환 -> PageableExecutionUtils 등으로 개선.
        return page;
    }

    private BoardSummaryProjection hideTitleIfSuspended(BoardSummaryProjection board) {
        return board.status() == BoardStatus.SUSPENDED
                ? board.toBuilder()
                        .title("접근할 수 없는 게시물입니다.")
                        .build()
                : board;
    }
}
