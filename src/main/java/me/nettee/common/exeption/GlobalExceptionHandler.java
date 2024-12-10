package me.nettee.common.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 내장된 AOP (다른 라이브러리 없이 사용 가능한 AOP)
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class) // 모든 커스텀 익셉션
    public ResponseEntity<?/* NOTE 나중에 예외 응답 타입 */> handleCustomException(CustomException exception) {
        // NOTE 나중에는 record를 바깥에 따로 만들어서 구체적으로 다룸.
        //  @see https://github.com/merge-simpson/demo-exception-handler/blob/main/src/main/java/com/example/common/exception/response/ApiResponseError.java
        record ApiErrorResponse(
                int status,
                String code,
                String message
                // ...
        ) {}

        ErrorCode errorCode = exception.getErrorCode();

        var responseBody = new ApiErrorResponse(
                errorCode.defaultHttpStatus().value(),
                errorCode.name(),
                exception.getMessage() // same to errorCode.defaultMessage()
        );

        /*
          Response body:
            {"status": 404, "code": "BOARD_NOT_FOUND", "message": "게시물을 찾을 수 없습니다."}
         */
        return ResponseEntity
                .status(errorCode.defaultHttpStatus())
                .body(responseBody);
    }
}
