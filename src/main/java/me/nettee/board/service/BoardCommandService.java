package me.nettee.board.service;

import lombok.RequiredArgsConstructor;
import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.domain.Board;
import me.nettee.board.domain.type.BoardStatus;
import me.nettee.board.exception.BoardCommandErrorCode;
import me.nettee.board.mapper.BoardDtoMapper;
import me.nettee.board.repository.BoardCommandRepository;
import me.nettee.board.usecase.BoardCreateUseCase;
import me.nettee.board.usecase.BoardDeleteUseCase;
import me.nettee.board.usecase.BoardUpdateUseCase;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BoardCommandService
        implements BoardCreateUseCase,
        BoardUpdateUseCase,
        BoardDeleteUseCase {

    private final BoardCommandRepository boardCommandRepository;
    private final BoardDtoMapper mapper;

    @Override
    public Board create(Board board) {
        return boardCommandRepository.save(board);
    }

    @Override
    public Board create(BoardCreateRequest request) {
        // 전처리 (DTO → Entity)
        Instant now = Instant.now();
//        var board = Board.builder()
//                .title(request.title())
//                .content(request.content())
//                .status(BoardStatus.ACTIVE)
//                .createdAt(now)
//                .updatedAt(now)
//                .build();
        Board board = mapper.toEntity(request, BoardStatus.ACTIVE, now, now);

        // delegation
        return create(board);
    }

    @Override
    public Board update(Long id, String title, String content) {
        Board board = findBoardById(id);

        board.prepareUpdate()
                .title(title)
                .content(content)
                .update();

        return board;
    }

    @Override
    public void delete(Long id) {
        Board board = findBoardById(id);

        if (board.status() == BoardStatus.REMOVED) {
            throw BoardCommandErrorCode.BOARD_GONE.defaultException();
        }

        board.setToDelete();
    }

    private Board findBoardById(Long id) {
        Board board = boardCommandRepository
                .findById(id)
                .orElseThrow(BoardCommandErrorCode.BOARD_NOT_FOUND::defaultException);

        if (board.status() == BoardStatus.REMOVED) {
            throw BoardCommandErrorCode.BOARD_GONE.defaultException();
        }

        return board;
    }
}
