import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TenMinuteWalkTest {
    @Test
    public void Test() {
        assertEquals("Should return true", true, TenMinuteWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
    }
    @Test
    public void Test2() {
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
    }
    @Test
    public void Test3() {
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'w'}));
    }
    @Test
    public void Test4() {
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
