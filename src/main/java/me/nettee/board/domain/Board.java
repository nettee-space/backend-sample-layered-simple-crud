package me.nettee.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.nettee.board.domain.type.BoardStatus;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private BoardStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    @Builder(
            builderClassName = "UpdateBoardBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
