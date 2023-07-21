package main.java;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderAndWriter {
    public void writer(String text){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/cryptedText.txt"))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String reader() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/resources/initialText.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
