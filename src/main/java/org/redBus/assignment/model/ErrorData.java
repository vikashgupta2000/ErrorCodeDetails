package org.redBus.assignment.model;

import java.util.Date;

public class ErrorData {
    private Date date;
    private ErrorCode errorCode;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
