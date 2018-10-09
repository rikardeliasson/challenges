import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class PigLatinTest {

    public static String pigIt(String str) {
        String words = "";
        for(String word : str.split(" ")) {
            if(word.matches("[a-zA-Z]+")) {
                String end = word.charAt(0) + "ay";
                words += (word.substring(1, word.length()) + end + " ");
            }
            else {
                words += word;
            }
        }
        return words.trim();
    }

    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
    }

}
