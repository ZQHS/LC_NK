import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class OptionTest {
    public static void main(String[] args) {
        char[] chars = "abcd".toCharArray();
        ArrayList<Integer> integers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(4);
                add(3);
            }
        };

        Optional<Integer> f = new OptionTest().f();
        Integer integer = f.orElseGet(() -> new Random().nextInt());
        System.out.println(integer);
//
//        integers.stream().filter(x -> x > 2);
//        integers.stream().map(x -> x * 2).forEach(System.out::println);
    }

    public Optional<Integer> f() {
        return Optional.ofNullable(null);
    }
}
