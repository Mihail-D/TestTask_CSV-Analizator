import readers.FileReaderFactory;
import readers.FilesReader;

import java.io.FileReader;
import java.util.TimerTask;

public class CsvParserApp {

    public static void main(String[] args) {
        //TODO: Implement me
        final String FILE_PATH = "./src/main/resources/address.csv";
        //final String FILE_PATH = "./src/main/resources/address.xml";

        FilesReader fileReader = FileReaderFactory.getFileReader(FILE_PATH);

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.currentTimeMillis();

        // TODO: Implement me
        fileReader.readFromFile(FILE_PATH);

        long endTime = System.currentTimeMillis();

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        double memoryUsedInMegabytes = (double) (usedMemoryAfter - usedMemoryBefore) / (1024 * 1024);

        System.out.println("Использовано памяти: " + String.format("%.2f", memoryUsedInMegabytes) + " Мегабайт");
        System.out.println("Время выполнения: " + (endTime - startTime) + " миллисекунд");
    }
}
