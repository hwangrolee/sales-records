package com.hwangrolee.SalesRecords.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends AbstractException {

    @JsonIgnore
    private Map<String, String> parameters = new HashMap<String, String>();

    public ParameterException() {
        super.code = 403;
        super.message = "파라미터가 잘못되었습니다.";
    }

    public String addParameter(Object value, String parameterName, ExceptionType exceptionType) {
        String cause = String.format("%s이 %s(value: %s)", parameterName, exceptionType.getCause(), value);
        super.cause.put(parameterName, cause);
        return cause;
    }
    public String addParameter(Object value, String parameterName, String type, ExceptionType exceptionType) {
        String cause = String.format("%s이 %s %s(value: %s)", parameterName, type, exceptionType.getCause(), value);
        super.cause.put(parameterName, cause);
        return cause;
    }

    public boolean isException() {
        return parameters.size() > 0;
    }
}
