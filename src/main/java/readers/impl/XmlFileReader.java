package readers.impl;

import processors.DataProcessor;
import processors.XmlStringFormatter;
import readers.FilesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlFileReader implements FilesReader {

    private static final Map<String, List<Integer>> estateRegister = new HashMap<>();

    @Override
    public void readFromFile(String path) {
        if (!Files.exists(Path.of(path))) {
            throw new RuntimeException("Файл отсутствует. Укажите корректный путь к файлу.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.contains("?xml") && !line.contains("root")) {
                    String str = XmlStringFormatter.formatXmlString(line);
                    String[] data = str.split(";");

                    String key = data[0] + " " + data[1] + " " + data[2];
                    int value = Integer.parseInt(data[3]);
                    estateRegister.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataProcessor.processEstateRegister(estateRegister);
    }
}
