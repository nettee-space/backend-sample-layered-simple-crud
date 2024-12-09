package me.nettee.board.service;

import lombok.RequiredArgsConstructor;
import me.nettee.board.repository.BoardQueryRepository;
import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import me.nettee.board.usecase.BoardSelectAllUseCase;
import me.nettee.board.usecase.BoardSelectOneUseCase;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardQueryService
        implements BoardSelectOneUseCase,
        BoardSelectAllUseCase {

    private final BoardQueryRepository boardQueryRepository;

    @Override
    public BoardDetailProjection findById(Long id) {
        return boardQueryRepository.findBoardById(id)
                .orElseThrow(/* TODO add exception func */);
    }

    @Override
    public List<BoardSummaryProjection> findAllBy(Pageable pageable) {
        return boardQueryRepository.findBoardsBy(pageable);
    }
}
