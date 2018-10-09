import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
       List<Integer> resultList = new ArrayList<>();
       Arrays.stream(elements).forEach(i -> {
           if(Collections.frequency(resultList, i) < maxOccurrences) {
               resultList.add(i);
           }
       });
       return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}