package me.nettee.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateResponse;
import me.nettee.board.usecase.BoardCreateUseCase;
import me.nettee.board.usecase.BoardDeleteUseCase;
import me.nettee.board.usecase.BoardUpdateUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommandApi {
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardUpdateUseCase boardUpdateUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;

    @PostMapping
    public BoardCreateResponse create(
            @RequestBody @Valid BoardCreateRequest request
    ) {
        var board = boardCreateUseCase.create(request);

        return BoardCreateResponse.builder()
                .board(board)
                .build();
    }
}
