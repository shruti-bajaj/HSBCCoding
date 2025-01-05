package hsbc.codingexercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ReverseFileContentTest {

    private ReverseFileContent target;

    @Before
    public void setUp() throws Exception {
        target = new ReverseFileContent();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverseFileContentToAnotherFileSuccessTest() throws IOException, URISyntaxException {
        String inputContent = "ABC";
        Files.write(Paths.get(ReverseFileContent.INPUT_FILE_NAME), inputContent.getBytes(StandardCharsets.US_ASCII));
        assertTrue("reverseFileContentToAnotherFile success", target.reverseFileContentToAnotherFile());

        String outputContent = Files.lines(Paths.get(ReverseFileContent.OUTPUT_FILE_NAME), StandardCharsets.US_ASCII).collect(Collectors.joining());
        assertEquals("CBA", outputContent);

    }

    @Test
    public void reverseFileContentToAnotherFileEmptyInputContentTest() throws IOException, URISyntaxException {
        String inputContent = "";
        Files.write(Paths.get(ReverseFileContent.INPUT_FILE_NAME), inputContent.getBytes(StandardCharsets.US_ASCII));
        assertTrue("reverseFileContentToAnotherFile success", target.reverseFileContentToAnotherFile());

        String outputContent = Files.lines(Paths.get(ReverseFileContent.OUTPUT_FILE_NAME), StandardCharsets.US_ASCII).collect(Collectors.joining());
        assertEquals("", outputContent);

    }
}