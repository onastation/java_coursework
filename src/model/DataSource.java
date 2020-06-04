package model;
import org.apache.commons.math3.util.Precision;

import java.util.Random;

public class DataSource {
    public static Plant[] generateNewData(int num) {
        String[] types = {"flowering plant", "mosses", "conifers", "ferns"};
        String[] species = {"Rosaceae", "Liliaceae", "Peraceae", "Ericaceae", "Vitaceae"};
        String[] subspecies = {"Aronia", "Batidea", "Cydonia", "Dryas", "Exochorda",
                "Fragaria", "Ivesia", "Kerria", "Malus", "Prunus", "Rubus", "Spiraea"};
        String[] nameParts = {"aculeata", "boliviana", "caespitosa", "depressa", "interrupta", "juvenca",
                "lucida", "nivalis", "pallida", "vinosa"};
        Random rand = new Random();
        Plant[] plants = new Plant[num];
        int count = 0;
        String[] names = new String[num];
        while(count < num) {
            String name = subspecies[rand.nextInt(12)] + ' ' + nameParts[rand.nextInt(10)];
            Boolean unique = true;
            for (int i = 0; i < count + 1; i++){
                if(names[i]==name){
                    unique=false;
                }
            }
            if(unique){
                names[count++]=name;
            }
        }
        for (int i = 0; i < plants.length; i++) {
            plants[i] = new Plant(i+1,
                    names[i],
                    types[rand.nextInt(4)],
                    species[rand.nextInt(5)],
                    names[i].split(" ")[0],
                    rand.nextInt(100) + Precision.round(rand.nextFloat(), 2),
                    rand.nextInt(20));
        }
        return plants;
    }
}