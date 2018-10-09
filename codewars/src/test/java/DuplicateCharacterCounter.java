import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuplicateCharacterCounter {

    @Test
    public void emptyReturnsZero() {
        assertEquals(0, countDuplicates(""));
    }

    @Test
    public void onlyOneCharacterReturnsZero() {
        assertEquals(0,countDuplicates("a"));
    }

    @Test
    public void twoCharactersWithOnePairReturnsOne() {
        assertEquals(1, countDuplicates("aa"));
    }

    @Test
    public void longStringReturnsSix() {
        assertEquals(6, countDuplicates("aAaAbbcdefgGhii1123567889"));
    }

    public int countDuplicates(String text) {
        List<Character> listOfChars = new ArrayList<Character>();

        char[] charArray = text.toCharArray();
        for(char c : charArray) {
            listOfChars.add(Character.toLowerCase(c));
        }

        return (int) listOfChars.stream().filter(i -> Collections.frequency(listOfChars, i) >1).distinct().count();
    }
}
