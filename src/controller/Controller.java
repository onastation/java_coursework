package controller;
import model.*;
import utilities.*;
import view.Viewer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.concurrent.CancellationException;
import java.util.function.Function;

public class Controller {
    public static Logger logger = Logger.getLogger(Controller.class);
    static {
        logger.setLevel(Level.DEBUG);
    }
    Viewer viewer;
    RequestProcessing requestProcessing;
    private String getValidString(String message, Function<String, Void> validator) {
        String answer;
        while (true) {
            answer = viewer.getResponse(message);
            if (answer.equals("cancel")) {
                throw new CancellationException();
            }
            try {
                validator.apply(answer);
            } catch (RuntimeException ex) {
                logger.error(ex);
                viewer.printLocalizedMessage(ex.getMessage());
                continue;
            }
            break;
        }
        return answer;
    }
    private int getValidNumber(String message, Function<String, Void> validator) {
        String answer;
        int result;
        while (true) {
            answer = viewer.getResponse(message);
            if (answer.equals("cancel")) {
                throw new CancellationException();
            }
            try {
                validator.apply(answer);
                result = Integer.parseInt(answer);
            } catch (RuntimeException ex) {
                logger.error(ex);
                viewer.printLocalizedMessage(ex.getMessage());
                continue;
            }
            break;
        }
        return result;
    }

    public Controller() {
        viewer = new Viewer(System.in, System.out);
        requestProcessing = new RequestProcessing();
    }

    public void printAllData() {
        viewer.printMessage(DataConverter.printAll(requestProcessing.selectAll()));
    }

    public void listFlowering() {
        Plant[] plants = requestProcessing.listFlowering();
        viewer.printMessage(DataConverter.printAll(plants));
    }
    public void listSubspecies() {
        try {
            String species = getValidString("enter_species", Validator::isValidSpecies);
            String[] subspecies = requestProcessing.listSubspecies(species);
            viewer.printMessage(DataConverter.printSubspecies(subspecies));
        } catch (CancellationException ex) {}
    }

    public void generateNewData() {
        try {
            int amount = getValidNumber("enter_amount", Validator::isValidAmount);
            requestProcessing.setMainStorage(DataSource.generateNewData(amount));
        } catch (CancellationException ex) {}
    }

    public void readFromFile() {
        String filename = viewer.getResponse("enter_filename");
        String report = requestProcessing.readFromFile(filename);
        viewer.printLocalizedMessage(report);
    }

    public void writeToFile() {
        String filename = viewer.getResponse("enter_filename");
        String report = requestProcessing.writeToFile(filename);
        viewer.printLocalizedMessage(report);
    }

    public void changeLanguage() {
        String newLanguage = viewer.getResponse("enter_language");
        viewer.changeLanguage(newLanguage);
    }
    public void executeOptions(int option) {
        if (option == 1) {
            printAllData();
        } else if (option == 2) {
            generateNewData();
        } else if (option == 3) {
            listFlowering();
        } else if (option == 4) {
            listSubspecies();
        } else if (option == 5) {
            writeToFile();
        } else if (option == 6) {
            readFromFile();
        } else if (option == 7) {
            changeLanguage();
        } else if (option == 8) {
            requestProcessing.writeToFile("result.json");
            System.exit(0);
        } else {
            viewer.printLocalizedMessage("invalid_option");
        }
    }

    public void run() {
        String option;
        int intOpt;
        while (true) {
            option = viewer.getOptions();
            try {
                Validator.isNumber(option);
            } catch (NumberFormatException ex) {
                logger.error(ex);
                viewer.printLocalizedMessage(ex.getMessage());
                continue;
            }
            intOpt = Integer.parseInt(option);
            executeOptions(intOpt);
        }
    }
}