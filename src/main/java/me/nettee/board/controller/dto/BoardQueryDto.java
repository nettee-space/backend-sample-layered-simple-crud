package me.nettee.board.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import me.nettee.board.repository.projection.BoardProjection.BoardDetailProjection;
import me.nettee.board.repository.projection.BoardProjection.BoardSummaryProjection;

import java.util.List;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardSelectOneResponse(
            BoardDetailProjection board
    ) {}

    @Builder
    public record BoardSelectAllResponse(
            List<BoardSummaryProjection> boards,
            @JsonInclude(Include.NON_NULL) // null -> undefined (JSON에서 제외돼서)
            Integer page,
            @JsonInclude(Include.NON_NULL)
            Long total,
            @JsonInclude(Include.NON_NULL)
            Integer lastPage
    ) {}
}
