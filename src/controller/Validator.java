package controller;
import controller.exceptions.*;

public class Validator {
    public static void isNumber(String value) throws NumberFormatException {
        int asc;
        for (int character = 0; character < value.length(); character++) {
            asc = value.charAt(character);
            if (asc == 45) {
                continue;
            }
            if (asc < 48 || asc > 57) {
                throw new NumberFormatException("not_number");
            }
        }
    }
    public static Void isValidAmount(String value) throws InvalidNumberException {
        try {
            Validator.isNumber(value);
            int amount = Integer.parseInt(value);
            if (amount < 1 || amount > 120) {
                throw new InvalidNumberException("invalid_amount");
            }
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException("not_number");
        }
        return null;
    }
    public static Void isValidSpecies(String species) {
        char [] arrayOfString = species.toCharArray();
        if(species.length()==0){
            throw new InvalidSpeciesException(species);
        }
        Boolean invalid=false;
        for (int i = 0; i < arrayOfString.length; i++) {
            if (!Character.isAlphabetic(arrayOfString[i])) {
                invalid=true;
            }
        }
        if(invalid) {
            throw new InvalidSpeciesException("invalid_species");
        }
        return null;
    }
}