package me.nettee.board.controller;

import lombok.RequiredArgsConstructor;
import me.nettee.board.controller.dto.BoardQueryDto.BoardSelectAllResponse;
import me.nettee.board.controller.dto.BoardQueryDto.BoardSelectOneResponse;
import me.nettee.board.mapper.BoardDtoMapper;
import me.nettee.board.usecase.BoardSelectAllUseCase;
import me.nettee.board.usecase.BoardSelectOneUseCase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("boards")
@Validated
public class BoardQueryApi {

    private final BoardSelectOneUseCase boardSelectOneUseCase;
    private final BoardSelectAllUseCase boardSelectAllUseCase;
    private final BoardDtoMapper mapper;

    @GetMapping("/{id}")
    public BoardSelectOneResponse selectOne(@PathVariable("id") Long id) {
        var board = boardSelectOneUseCase.findById(id);

        return BoardSelectOneResponse.builder()
                .board(board)
                .build();
    }

    @GetMapping
    public BoardSelectAllResponse selectAll(
            @PageableDefault(size = 8)
            Pageable pageable
    ) {
        pageable = pageable.previousOrFirst();

        var page = boardSelectAllUseCase.findGeneralBy(pageable);

        return mapper.toResponse(page, pageable.getPageNumber() + 1);
    }
}
