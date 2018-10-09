




import org.apache.log4j.Logger;

import java.util.Arrays;

public class Solution {

    private static final Logger LOGGER = Logger.getLogger(Solution.class);

    public static int bowling_score(String frames) {


        String[] game = frames.split(" ");
        Arrays.stream(game).forEach(LOGGER.debug("I am logging that {} happened.", () -> compute()));

        return 0;
    }
}
