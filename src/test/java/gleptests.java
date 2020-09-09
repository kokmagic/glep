import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class gleptests {
    ArrayList<String> trueResult = new ArrayList<>();
    @Test
    public void GrepTest() throws IOException {
        ArrayList<String> result =
                new Grep(false, true, false, "привет", "src/testfiles/test1").grep();
        trueResult.add("Привет, как дела?");
        assertEquals(trueResult, result);
        trueResult.clear();
        result =
                new Grep(false, false, true, "\\s","src/testfiles/test2").grep();
        trueResult.add("Все отлично!");
        assertEquals(trueResult, result);
        trueResult.clear();
        result =
                new Grep(true, false, true, "\\s","src/testfiles/test2").grep();
        assertEquals(trueResult, result);
        result =
                new Grep(true, false, false, "меня","src/testfiles/test3").grep();
        trueResult.add("У ме ня тоже...");
        assertEquals(trueResult, result);
    }
}
