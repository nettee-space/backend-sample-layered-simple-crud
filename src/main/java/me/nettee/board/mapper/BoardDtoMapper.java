package me.nettee.board.mapper;

import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.domain.Board;
import me.nettee.board.domain.type.BoardStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING) // "spring"
public interface BoardDtoMapper {
    Board toEntity(BoardCreateRequest dto, BoardStatus status, Instant createdAt, Instant updatedAt);
}
