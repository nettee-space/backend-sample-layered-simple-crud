package me.nettee.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.nettee.board.domain.type.BoardStatus;
import me.nettee.common.jpa.support.BaseEntity;

import java.time.Instant;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Board extends BaseEntity {
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private BoardStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    public BoardStatus status() {
        return status;
    }

    @Builder(
            builderClassName = "UpdateBoardBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateBoard(String title, String content) {
        Objects.requireNonNull(title, "title cannot be null");
        Objects.requireNonNull(content, "content cannot be null");

        this.title = title;
        this.content = content;
    }

    public void softDelete() {
        this.status = BoardStatus.REMOVED;
    }
}
