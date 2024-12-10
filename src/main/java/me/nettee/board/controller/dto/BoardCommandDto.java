package me.nettee.board.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import me.nettee.board.domain.Board;

public final class BoardCommandDto {

    private BoardCommandDto() {}

    @Builder
    public record BoardCreateRequest(
            @NotBlank(message = "제목을 입력하십시오.") // Not null, Not empty(""), Not blank(" ")
            @Size(min = 3, message = "제목은 세 글자 이상 입력하세요.")
            @Size(max = 50, message = "제목은 최대 50글자입니다.")
            String title,

            @NotBlank(message = "본문을 입력하십시오.")
            @Size(min = 3, message = "본문은 세 글자 이상 입력하세요.")
            String content
    ) {}

    @Builder
    public record BoardUpdateRequest(
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            @Min(0) // (사실 불필요함)
            Long id,

            @NotBlank(message = "제목을 입력하십시오.") // Not null, Not empty(""), Not blank(" ")
            @Size(min = 3, message = "제목은 세 글자 이상 입력하세요.")
            @Size(max = 50, message = "제목은 최대 50글자입니다.")
            String title,

            @NotBlank(message = "본문을 입력하십시오.")
            @Size(min = 3, message = "본문은 세 글자 이상 입력하세요.")
            String content
    ) {}

    @Builder
    public record BoardCreateResponse(
            Board board
    ) {}

    @Builder
    public record BoardUpdateResponse(
            Board board
    ) {}

    // No response body to delete request
}
