package model;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import utilities.FileUtility;

import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;

public class RequestProcessing {
    public static Logger logger = Logger.getLogger(RequestProcessing.class);
    static {
        logger.setLevel(Level.DEBUG);
    }
    MainStorage mainStorage;
    public RequestProcessing() {
        this.mainStorage = new MainStorage();
    }

    public void setMainStorage(Plant[] plants) {
        mainStorage = new MainStorage(plants);
    }

    public String readFromFile(String filename) {
        try {
            mainStorage.setData(FileUtility.readFromFile(filename));
        } catch (IOException e) {
            logger.error(e);
            return e.getMessage();
        }
        return "reading_successful";
    }

    public String writeToFile(String filename) {
        try {
            FileUtility.writeToFile(mainStorage.getData(), filename);
        } catch (IOException e) {
            logger.error(e);
            return e.getMessage();
        }
        return "writing_successful";
    }

    public Plant[] selectAll() {
        return mainStorage.getData();
    }

    public Plant[] listFlowering() {
        Plant[] plants = mainStorage.getData();
        Plant[] resultPlants;
        int count = 0;
        for (Plant plant: plants) {
            if (plant.getType().equals("flowering plant")) {
                count++;
            }
        }
        resultPlants = new Plant[count];
        count = 0;
        for (Plant plant: plants) {
            if (plant.getType().equals("flowering plant")) {
                resultPlants[count++] = plant;
            }
        }
        return resultPlants;
    }
    public String[] listSubspecies(String species) {
        Plant[] plants = mainStorage.getData();
        int count = 0;
        String[] subspecies = new String[plants.length];
        for (Plant plant: plants) {
            if (species.equals(plant.getSpecies())) {
                subspecies[count++]=plant.getSubspecies();
            }
        }
        String[] result = new String[count];
        for(int i=0; i<=count; i++){
            if(subspecies[i]!=null){
                result[i]=subspecies[i];
            }
        }
        HashSet<String> HashSet = new HashSet<>( Arrays.asList(result) );
        String[] finalRes = HashSet.toArray(new String[] {});
        return finalRes;
    }
}