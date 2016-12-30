package org.redBus.assignment.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.redBus.assignment.model.ErrorData;
import org.redBus.assignment.service.ErrorCodeService;
import org.redBus.assignment.singleton.ErrorCodeStorage;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MyErrorCodeServiceImplTest {

    @Test
    public void shouldEvaluateTheLogFileAndStoreTheDataInSingleton() throws FileNotFoundException, ParseException {
        final String FILE_NAME = "testSampleLogFile.txt";
        final String REGEX_DATE_TIME_FORMAT = "\\d+-\\d+-\\d+ \\d+:\\d+:\\d+";
        final String SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        ErrorCodeService service = new MyErrorCodeServiceImpl(FILE_NAME, REGEX_DATE_TIME_FORMAT, SIMPLE_DATE_TIME_FORMAT);
        service.evaluate();
        Map<String, Map<String, List<ErrorData>>> map = ErrorCodeStorage.getInstance().getErrorDetailsMap();

        Assert.assertNotNull(map);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(2, map.get("2016-12-30").size());
        Assert.assertEquals(4, map.get("2016-12-30").get("500").size());
        Assert.assertEquals(3, map.get("2016-12-30").get("404").size());
    }
}
