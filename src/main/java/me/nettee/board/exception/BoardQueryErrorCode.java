package me.nettee.board.exception;

import me.nettee.common.exeption.ErrorCode;
import org.springframework.http.HttpStatus;

public enum BoardQueryErrorCode implements ErrorCode {
    BOARD_NOT_FOUND("존재하지 않는 게시물입니다.", HttpStatus.NOT_FOUND),
    BOARD_QUERY_FORBIDDEN("접근 권한이 없는 게시물입니다.", HttpStatus.FORBIDDEN),
    BOARD_GONE("더 이상 존재하지 않는 게시물입니다.", HttpStatus.GONE),
    DEFAULT("게시물 조회 오류" , HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus status;

    BoardQueryErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public BoardQueryException defaultException() {
        return new BoardQueryException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new BoardQueryException(this, cause);
    }
}
