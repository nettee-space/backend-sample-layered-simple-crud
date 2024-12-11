package me.nettee.board.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import me.nettee.board.controller.dto.BoardCommandDto.BoardCreateResponse;
import me.nettee.board.controller.dto.BoardCommandDto.BoardUpdateRequest;
import me.nettee.board.controller.dto.BoardCommandDto.BoardUpdateResponse;
import me.nettee.board.usecase.BoardCreateUseCase;
import me.nettee.board.usecase.BoardDeleteUseCase;
import me.nettee.board.usecase.BoardUpdateUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Validated
public class BoardCommandApi {
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardUpdateUseCase boardUpdateUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardCreateResponse create(
            @RequestBody @Valid BoardCreateRequest request
    ) {
        var board = boardCreateUseCase.create(request);

        return BoardCreateResponse.builder()
                .board(board)
                .build();
    }

//    @PostMapping
//    public ResponseEntity<BoardCreateResponse> create2(
//            @RequestBody @Valid BoardCreateRequest request
//    ) {
//        var board = boardCreateUseCase.create(request);
//
//        var dto =  BoardCreateResponse.builder()
//                .board(board)
//                .build();
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(dto);
//    }

    @PutMapping("/{id}")
    public BoardUpdateResponse update(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id,
            @RequestBody @Valid BoardUpdateRequest request
    ) {
        var board = boardUpdateUseCase.update(id, request.title(), request.content());

        return BoardUpdateResponse.builder()
                .board(board)
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id
    ) {
        boardDeleteUseCase.delete(id);
    }
}
