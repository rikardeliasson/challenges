import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToRomanTest {

    ToRoman toRoman = new ToRoman();

    @Test
    public void test1() {
        assertEquals("solution(1) should equal to I", "I", toRoman.solution(1));
    }

    @Test
    public void test2() {
        assertEquals("solution(4) should equal to IV", "IV", toRoman.solution(4));
    }

    @Test
    public void test3() {
        assertEquals("solution(6) should equal to VI", "VI", toRoman.solution(6));
    }
}
