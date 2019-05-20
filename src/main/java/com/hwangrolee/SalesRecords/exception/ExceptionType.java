package com.hwangrolee.SalesRecords.exception;

public enum ExceptionType {
    EMPTY("이 비어있습니다.", 501),
    NOT_FOUND("을(를) 찾을 수 없습니다.", 502),
    INVALID("형식에 맞지 않습니다.", 503),
    UNKNOWN("알수없는 에러입니다.", 500);

    private String cause;
    private int code;

    ExceptionType(String cause, int code) {
        this.cause = cause;
        this.code = code;
    }

    public String getCause() {
        return cause;
    }

    public int getCode() {
        return code;
    }
}
