package org.redBus.assignment.handler;

import org.junit.Assert;
import org.junit.Test;
import org.redBus.assignment.service.ErrorCodeService;

public class ErrorCodeHandlerTest {

    @Test
    public void shouldReturnInstanceOfMyErrorCodeService() {
        ErrorCodeService service = Enum.valueOf(ErrorCodeHandler.class , "MY_ERROR_CODE_SERVICE").errorFileReaderService(null, null, null);
        Assert.assertEquals("MyErrorCodeServiceImpl", service.getClass().getSimpleName());
    }
}
