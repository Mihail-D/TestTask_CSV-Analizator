package processors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataProcessor {

    public static void processEstateRegister(Map<String, List<Integer>> estateRegister) {
        estateRegister.forEach((key, floors) -> {
            Map<Integer, Long> floorCount = floors.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            int maxFloor = floors.stream().max(Integer::compare).orElse(-1);

            System.out.println("Ключ: " + key);
            floorCount.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> System.out.println("Дублирующая запись: " + key + ";" + entry.getKey() +
                            " Количество повторений: " + entry.getValue()));
            System.out.println("Максимальный этаж: " + maxFloor);
            System.out.println("-----");
        });
    }
}
