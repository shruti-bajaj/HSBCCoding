package hsbc.codingexercise;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseFileContent {

    public static final String INPUT_FILE_NAME = "src/main/resources/input.txt";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/output.txt";

    private static Stream<String> readFile(String inputFileName) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(inputFileName), StandardCharsets.US_ASCII);
    }

    private static String reverseContent(Stream<String> stream) {

        return stream.map(x -> new StringBuilder(x).reverse())
                .collect(Collectors.joining(" "));
    }

    private static void writeToFile(String content, String outputFileName) throws IOException {
        Files.write(Paths.get(outputFileName), content.getBytes(StandardCharsets.US_ASCII));
    }

    public Boolean reverseFileContentToAnotherFile() {
        String content = null;
        try {
            content = ReverseFileContent.reverseContent(ReverseFileContent.readFile(INPUT_FILE_NAME));
            if (Objects.nonNull(content)) {
                ReverseFileContent.writeToFile(content, OUTPUT_FILE_NAME);
            } else {
                return false;
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}