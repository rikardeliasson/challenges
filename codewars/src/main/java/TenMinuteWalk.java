import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TenMinuteWalk {

    public static boolean isValid(char[] walk) {
        if(walk.length != 10) {
            return false;
        }
        List<Character> theWalk = new ArrayList<>();
        for(char direction : walk) {
            theWalk.add(direction);
        }
        if(Collections.frequency(theWalk, 'n') == Collections.frequency(theWalk, 's') &&
                Collections.frequency(theWalk, 'w') == Collections.frequency(theWalk, 'e')) {
            return true;
        }
        return false;
    }
}
