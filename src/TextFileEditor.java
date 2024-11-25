import java.io.*;
import java.nio.file.*;

public class TextFileEditor {
    private String filePath;

    public TextFileEditor(String filePath) {
        this.filePath = filePath;
    }

    // Method to replace a word in the file and write it back
    public void replaceWord(String oldWord, String newWord) {
        try {
            Path path = Paths.get(filePath);
            String content = new String(Files.readAllBytes(path));

            // Replace the word
            content = content.replace(oldWord, newWord);

            // Write the modified content back to the file
            Files.write(path, content.getBytes());
            System.out.println("Replacement complete.");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}

