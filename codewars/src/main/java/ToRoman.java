import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToRoman {

    private static final Map<Integer,String> map = new HashMap<>();
    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }

    public String solution(int n) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        String[] numbers = (""+n).split("");
        System.out.println(map.keySet());


        return "";
    }
}