import java.util.ArrayList;
import java.util.List;

public class Line {
    public static String tickets(int[] peopleInLine) {
        List<Integer> change = new ArrayList<>();
        for(int money : peopleInLine) {
            if(money == 25) {
                change.add(25);
            }
            else if(money == 50) {
                change.add(50);
                if(!change.remove((Integer)25)) {
                    return "NO";
                }
            }
            else if(money == 100) {
                change.add(100);
                if(!change.remove((Integer)25) || !change.remove((Integer)50)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}