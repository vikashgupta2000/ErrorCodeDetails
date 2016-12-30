package org.redBus.assignment.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileReaderTest {
    @Test
    public void shouldReadFileFromResources() throws IOException {
        String fileName = "testSampleLogFile.txt";
        FileReader fileReader = new FileReader();
        List<String> logDatas = fileReader.readFileAndConvertToList(fileName);
        Assert.assertNotNull(logDatas);
        Assert.assertEquals(7, logDatas.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowErrorIfWrongFileNameIsProvided() throws IOException {
        String fileName = "WrongFileName.txt";
        FileReader fileReader = new FileReader();
        List<String> logDatas = fileReader.readFileAndConvertToList(fileName);
    }
}
