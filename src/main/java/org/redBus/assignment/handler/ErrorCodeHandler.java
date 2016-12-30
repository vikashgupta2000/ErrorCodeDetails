package org.redBus.assignment.handler;

import org.redBus.assignment.service.ErrorCodeService;
import org.redBus.assignment.service.impl.MyErrorCodeServiceImpl;

public enum ErrorCodeHandler {
    MY_ERROR_CODE_SERVICE {
        @Override
        public ErrorCodeService errorFileReaderService(String fileName, String datePattern, String simpleDateTimeFormat) {
            return new MyErrorCodeServiceImpl(fileName, datePattern, simpleDateTimeFormat);
        }
    };

    public abstract ErrorCodeService errorFileReaderService(String fileName, String datePattern, String simpleDateTimeFormat);
}
