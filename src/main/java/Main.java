import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static String mostCommonFourDigits(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (char num : input.toCharArray()) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return map.entrySet().stream()
                .sorted(Comparator
                        .comparingInt((Map.Entry<Character, Integer> entry) -> entry.getValue()).reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .limit(4)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/hyperskill-dataset-117268420.txt");

        try (Scanner scanner = new Scanner(file)) {
            StringBuilder stringBuilder = new StringBuilder();

            while(scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }

            System.out.println(mostCommonFourDigits(stringBuilder.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
