package springboot.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.demo.exeption.FileReaderException;
import springboot.demo.service.ReadFileService;

@SpringBootTest
class ReadFileServiceImplTest {
    private static final String TEST_PATH = "src/test/resources/test.csv";
    private static final String TEST_PATH_EMPTY = "src/test/resources/empty.csv";
    private static final String TEST_PATH_WRONG = "src/test/resources/wrong.csv";

    private final ReadFileService readFileService;

    @Autowired
    ReadFileServiceImplTest(ReadFileService readFileService) {
        this.readFileService = readFileService;
    }

    @Test
    public void readFile_Ok() {
        List<String> actual = List.of("First test line for testing how my ReadFileService working",
                "Second test line for testing how my ReadFileService working");
        List<String> expected = readFileService.readFromFile(TEST_PATH);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readEmptyFile_Ok() {
        List<String> actual = new ArrayList<>();
        List<String> expected = readFileService.readFromFile(TEST_PATH_EMPTY);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExpected() {
        assertThrows(FileReaderException.class,
                () -> readFileService.readFromFile(TEST_PATH_WRONG));
    }
}
