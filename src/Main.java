import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1.");
        List<Integer> list = new ArrayList<>(List.of(1,5,0,8,9,10,11,25,20));
        findMinMax(list.stream(),Integer::compareTo,(min, max) -> System.out.printf("min %s, max %s%n", min, max));
        System.out.printf("Количество четных чисел = %s%n", getCountEvenNumbers(list));

    }

    private static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    private static long getCountEvenNumbers(List<Integer> list) {
        System.out.println("Задача 2.");
        return list.stream().filter(item -> item % 2 == 0).count();
    }
}