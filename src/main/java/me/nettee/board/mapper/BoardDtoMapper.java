package me.nettee.board.mapper;

import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.controller.dto.BoardQueryDto.BoardSelectAllResponse;
import me.nettee.board.domain.Board;
import me.nettee.board.domain.type.BoardStatus;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING) // "spring"
public interface BoardDtoMapper {
    Board toEntity(BoardCreateRequest dto, BoardStatus status, Instant createdAt, Instant updatedAt);

    default BoardSelectAllResponse toResponse(Page<BoardSummaryProjection> boards, int currentPage) {
        return BoardSelectAllResponse.builder()
                .boards(boards.stream().toList())
                .page(currentPage)
                .total(boards.getTotalElements())
                .lastPage(boards.getTotalPages())
                .build();
    }
}
