import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class gleptests {
    ArrayList<String> trueResult = new ArrayList<>();
    @Test
    public void GrepTest() throws IOException {
        ArrayList<String> result =
                new Grep(false, false, true, "\\d", "testfiles/testfile1.txt").grep();
        trueResult.add("Привет, привет, прИвет, пpивет");
        assertEquals(trueResult, result);

    }
}
