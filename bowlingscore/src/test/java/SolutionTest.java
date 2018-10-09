import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    public void BasicTests() {

        System.out.println("Maybe this bowler should put bumpers on...\n ");
        assertEquals(20, Solution.bowling_score("11 11 11 11 11 11 11 11 11 11"));

        System.out.println("Woah! Perfect game!");
        assertEquals(300, Solution.bowling_score("X X X X X X X X X XXX"));
    }

    @Test
    public void shouldReturnReturnZeroIfNotCompleteRound() {
        assertEquals(0, Solution.bowling_score("11 11 11 11 11 11 11 11 11"));
    }

    @Test
    public void shouldReturnZeroIfNoPinsKnockedDown() {
        assertEquals(0, Solution.bowling_score("00 00 00 00 00 00 00 00 00 00"));
    }

    @Test
    public void shouldReturnZeroIfBonusButNoBonusOnLastFrame() {
        assertEquals(0, Solution.bowling_score("11 22 33 44 55 66 77 88 99 111"));
    }
}
