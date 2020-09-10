import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class glepTests {
    ArrayList<String> trueResult = new ArrayList<>();
    @Test
    public void GrepTest1() throws IOException {
        ArrayList<String> result =
                new Grep(false, true, false, "привет", "testfiles/test1").grep();
        trueResult.add("Привет, как дела?");
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest2() throws IOException {
        ArrayList<String> result =
                new Grep(false, false, true, "\\s","testfiles/test2").grep();
        trueResult.add("Все отлично!");
        trueResult.add("Привет прИвет пРИвЕт ПРИвет");
        trueResult.add("КАК ВАМ ТАКОЕ");
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest3() throws IOException {
        ArrayList<String> result =
                new Grep(true, false, true, "\\s","testfiles/test2").grep();
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest4() throws IOException {
        ArrayList<String> result =
                new Grep(true, false, false, "меня","testfiles/test3").grep();
        trueResult.add("У ме ня тоже...");
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest5() throws IOException {
        ArrayList<String> result =
                new Grep(false, true, false, "привет", "testfiles/test2").grep();
        trueResult.add("Привет прИвет пРИвЕт ПРИвет");
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest6() throws IOException {
        ArrayList<String> result =
                new Grep(false, true, true, "[а-я]+", "testfiles/test2").grep();
        trueResult.add("Все отлично!");
        trueResult.add("Привет прИвет пРИвЕт ПРИвет");
        trueResult.add("КАК ВАМ ТАКОЕ");
        assertEquals(trueResult, result);
    }

    @Test
    public void GrepTest7() throws IOException {
        ArrayList<String> result =
                new Grep(false, false, true, "[В]+", "testfiles/test2").grep();
        trueResult.add("Все отлично!");
        trueResult.add("КАК ВАМ ТАКОЕ");
        assertEquals(trueResult, result);
    }


}
