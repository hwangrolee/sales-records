package com.hwangrolee.SalesRecords.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractException extends Exception {

    protected int code = 500;
    protected Map<String, String> cause = new HashMap<String, String>(){{ put("UNKNOWN", "알수없음"); }};
    protected String message = "";
    protected ExceptionType type = ExceptionType.UNKNOWN;
}
