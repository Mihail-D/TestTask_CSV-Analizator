package readers;

public class FileReaderFactory {
    public static FilesReader getFileReader(String path) {
        if (path.endsWith(".csv")) {
            return new CsvFileReader();
        } else if (path.endsWith(".xml")) {
            return new XmlFileReader();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}
