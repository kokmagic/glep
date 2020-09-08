import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {


    private final boolean flagV;

    private final boolean flagI;

    private final boolean flagR;

    private final String wordFilter;

    private final String inputFile;

    public Grep(boolean flagV, boolean flagI, boolean flagR, String wordFilter, String inputFile) {
        this.flagV = flagV;
        this.flagI = flagI;
        this.flagR = flagR;
        this.wordFilter = wordFilter;
        this.inputFile = inputFile;
    }

    public ArrayList<String> grep() throws IOException {
        Pattern pattern;
        if (flagR) {
            if (flagI) pattern = Pattern.compile(wordFilter, Pattern.CASE_INSENSITIVE);
            else pattern = Pattern.compile(wordFilter);
        } else if (flagI) pattern = Pattern.compile(wordFilter.toLowerCase());
        else pattern = Pattern.compile(wordFilter);
        BufferedReader input = new BufferedReader(new FileReader(inputFile));
        String line;
        try (input) {
            ArrayList<String> output = new ArrayList<String>();
            while ((line = input.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (flagV & !matcher.find()) output.add(line);
                if (!flagV & matcher.find()) output.add(line);
            }
            return output;
        }

    }
}
