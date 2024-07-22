package validators;

import java.io.File;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern CSV_STRING_PATTERN = Pattern.compile(
            "^\"[^\"]+\";\"[^\"]+\";\\d+;\\d+$");
    private static final Pattern XML_ITEM_PATTERN = Pattern.compile(
            "<item\\s+city=\"([^\"]+)\"\\s+street=\"([^\"]+)\"\\s+house=\"(\\d+)\"\\s+floor=\"(\\d+)\"\\s*/>"
    );


    public static void isCsvStringValid(String csvString) throws IllegalArgumentException {
        if (!CSV_STRING_PATTERN.matcher(csvString).matches()) {
            throw new IllegalArgumentException("Строка не соответствует формату CSV.");
        }
    }

    public static void isXmlStringValid(String xmlString) throws IllegalArgumentException {
        if (!XML_ITEM_PATTERN.matcher(xmlString).matches()) {
            throw new IllegalArgumentException("Строка не соответствует формату XML.");
        }
    }

    public static void validateFilePath(String filePath) throws IllegalArgumentException {
        if (filePath == null || !new File(filePath).exists() ) {
            throw new IllegalArgumentException("Файл по указанному пути не найден");
        }
    }
}
