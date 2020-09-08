import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class GrepLauncher {
    @Option(name = "-v", usage = "Inverts the filter condition")
    private boolean flagV;

    @Option(name = "-i", usage = "Ignore case")
    private boolean flagI;

    @Option(name = "-r", usage = "Sets regular expression to search")
    private boolean flagR;

    @Argument(usage = "Sets the word to search")
    private String wordFilter;

    @Argument(required = true, usage = "Input file")
    private String inputFile;

    public static void main(String[] args) {
        new GrepLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("grep [-v] [-i] [-r] word file");
            parser.printUsage(System.err);
            return;
        }
        Grep grep = new Grep(flagV, flagI, flagR, wordFilter, inputFile);
        try {
            grep.grep();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
