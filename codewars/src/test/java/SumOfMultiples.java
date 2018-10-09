import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumOfMultiples {

    public int solution(int number) {
        List<Integer> numbers = IntStream.rangeClosed(0, number-1).boxed().collect(Collectors.toList());
       numbers = numbers.stream().filter(i -> {
           if (Math.floorMod(i, 3) == 0 || Math.floorMod(i, 5) == 0) {
               return true;
           }
           return false;
       }).collect(Collectors.toList());
       System.out.println(numbers);
        return numbers.stream().reduce(0, Integer::sum);

    }

    @Test
    public void test() {
        assertEquals(23, solution(10));
    }


}
