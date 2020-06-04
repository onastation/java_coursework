package utilities;
import model.*;
public class DataConverter {
    public static String printAll(Plant[] plants) {
        StringBuilder result = new StringBuilder("");
        if (plants != null) {
            result.append("Plants:\n");
            result.append(String.format("%5s | %20s | %20s | %15s | %15s | %10s | %10s\n",
                    "ID", "Name", "Type", "Species", "Subspecies", "Price", "Amount"));
            for (Plant plant : plants) {
                String res=String.format("%5d | %20s | %20s | %15s | %15s | %10.2f | %10d\n",
                        plant.getPlantID(), plant.getName(), plant.getType(),
                        plant.getSpecies(), plant.getSubspecies(), plant.getPrice(), plant.getAmount());
                result.append(res);
            }
        }
        else {
            result.append("-");
        }
        return result.toString();
    }
    public static String printSubspecies(String[] subspecies) {
        String count = Integer.toString(subspecies.length);
        String result = "There are " + count + " subspecies.\n";
        if (subspecies != null) {
            result += "List of subspecies:";
            for (String subs: subspecies) {
                result = result + '\n'+ subs;
            }
        }
        return result;
    }
}