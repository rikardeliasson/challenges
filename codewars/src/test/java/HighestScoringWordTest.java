import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HighestScoringWordTest {

    HighestScoringWord highestScoringWord;

    @Test
    public void sampleTests() {
        assertEquals("taxi", highestScoringWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", highestScoringWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", highestScoringWord.high("take me to semynak"));
    }

    @Test
    public void Test2() {
        assertEquals("qqotczpyaru", highestScoringWord.high("qqotczpyaru"));
    }

    @Test
    public void Test3() {
        assertEquals("ejptmfpxdmbqaap", highestScoringWord.high("ejptmfpxdmbqaap"));
    }
    @Test
    public void Test4() {
        assertEquals("yquyiqgvb", highestScoringWord.high("yquyiqgvb"));
    }
    @Test
    public void Test5() {
        assertEquals("zfzqlyfebie", highestScoringWord.high("zfzqlyfebie"));
    }
    @Test
    public void Test6() {
        assertEquals("aaaaaaaaa", highestScoringWord.high("aaaaaaaaa"));
    }
}
