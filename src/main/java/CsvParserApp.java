import java.io.FileReader;

public class IpCounterApp {

    public static void main(String[] args) {
        //TODO: Implement me
        final String FILE_PATH = "./src/main/resources/address.csv";
        FileReader fileReader = new FileReader(FILE_PATH);

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.currentTimeMillis();

        //fileReader.readLinesFromFile();

        long endTime = System.currentTimeMillis();

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        double memoryUsedInMegabytes = (double) (usedMemoryAfter - usedMemoryBefore) / (1024 * 1024);

        System.out.println("Использовано памяти: " + String.format("%.2f", memoryUsedInMegabytes) + " Мегабайт");
        System.out.println("Время выполнения: " + (endTime - startTime) + " миллисекунд");
    }
}
