package me.nettee.board.repository.projection;

import lombok.Builder;
import me.nettee.board.domain.type.BoardStatus;

import java.time.Instant;

public final class BoardProjection {

    // 내부 클래스
    @Builder(toBuilder = true)
    public record BoardSummaryProjection(
            Long id,
            String title,
            BoardStatus status,
            Instant createdAt
    ) {}

    @Builder
    public record BoardDetailProjection(
            Long id,
            String title,
            String content,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {}
}