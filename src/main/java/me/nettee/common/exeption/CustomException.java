package me.nettee.common.exeption;

public class CustomException extends RuntimeException {
    protected ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.defaultMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.defaultMessage(), cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    // NOTE 나중엔 더 많은 생성자와 Default error code 등이 추가됨
    //  @see https://github.com/merge-simpson/letsdev-error-code-api/blob/main/src/main/java/letsdev/common/exception/support/CustomException.java
}
