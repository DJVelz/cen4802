import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class LogApp {

    private static final Logger logger = Logger.getLogger(LogApp.class.getName());
    private static final String LOG_FILE = "app.log";

    public static void main(String[] args) throws IOException {
        setupLogger();

        //Generate 100 log entries of various levels
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                logger.severe("Critical failure occurred at iteration " + i);
            } else if (i % 5 == 0) {
                logger.warning("Potential issue detected at iteration " + i);
            } else {
                logger.info("Process running normally at iteration " + i);
            }
        }

        //Parse and extract WARNING and SEVERE logs
        System.out.println("\n--- Extracted Warnings and Errors ---");
        parseLogForSeverity(LOG_FILE, "SEVERE");
    }

    private static void setupLogger() throws IOException {
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());

        FileHandler fileHandler = new FileHandler(LOG_FILE, false);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
    }

    private static void parseLogForSeverity(String fileName, String severity) {
        System.out.println("\n--- Extracting Logs with Level: " + severity + " ---");
        String regex = ".*\\b" + severity + "\\b: (.+)";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("[" + severity + "] " + matcher.group(1));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}
