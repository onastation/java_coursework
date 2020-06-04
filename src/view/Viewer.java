package view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Viewer {
    Scanner scanner;
    PrintStream printStream;
    LocalizationConfiguration localizationConfiguration;
    public Viewer(InputStream input, PrintStream output) {
        scanner = new Scanner(input);
        printStream = output;
        localizationConfiguration = LocalizationConfiguration.INSTANCE;
    }

    public void printOptions() {
        printStream.println(localizationConfiguration.getLocalized("choose_option"));
        printStream.println(localizationConfiguration.getLocalized("option_1"));
        printStream.println(localizationConfiguration.getLocalized("option_2"));
        printStream.println(localizationConfiguration.getLocalized("option_3"));
        printStream.println(localizationConfiguration.getLocalized("option_4"));
        printStream.println(localizationConfiguration.getLocalized("option_5"));
        printStream.println(localizationConfiguration.getLocalized("option_6"));
        printStream.println(localizationConfiguration.getLocalized("option_7"));
        printStream.println(localizationConfiguration.getLocalized("option_8"));
    }
    public String getOptions() {
        printOptions();
        String action = scanner.nextLine();
        return action;
    }
    public String getResponse(String text) {
        printStream.println(localizationConfiguration.getLocalized(text));
        String response = scanner.nextLine();
        return response;
    }
    public void printMessage(String message) {
        printStream.println(message);
    }
    public void printLocalizedMessage(String message) {
        printStream.println(localizationConfiguration.getLocalized(message));
    }
    public void changeLanguage(String languageOption) {
        if (languageOption.equals("1")) {
            localizationConfiguration.changeLanguage(new Locale("en", "US"));
        } else if (languageOption.equals("2")) {
            localizationConfiguration.changeLanguage(new Locale("uk", "UA"));
        } else {
            printLocalizedMessage("invalid_option");
            return;
        }
        printLocalizedMessage("language_changed");
    }
}