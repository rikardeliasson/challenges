import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PileOfCubesBuilder {

    public static long findNb(long m) {
        long nb = 0, result = 0;
        while (result < m) {
            result += (long) Math.pow(++nb, 3);
        }
        return result == m ? nb : -1;
    }


    @Test
    public void test1() {
        assertEquals(2022, findNb(4183059834009L));
    }
    @Test
    public void test2() {
        assertEquals(-1, findNb(24723578342962L));
    }
    @Test
    public void test3() {
        assertEquals(4824, findNb(135440716410000L));
    }
    @Test
    public void test4() {
        assertEquals(3568, findNb(40539911473216L));
    }

    @Test
    public void Test5() {
        assertEquals(2, findNb(9));
    }

    @Test
    public void Test6() {
        assertEquals(3, findNb(36));
    }

    @Test
    public void Test7() {
        assertEquals(1, findNb(1));
    }

}
