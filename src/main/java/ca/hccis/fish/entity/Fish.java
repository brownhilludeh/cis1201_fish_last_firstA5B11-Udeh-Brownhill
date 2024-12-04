package ca.hccis.fish.entity;

import ca.hccis.util.CisUtility;

import java.util.Locale;

/**
 * Represents a fish for a fisherman
 *
 * @author
 * @since
 */

public class
Fish {

    public static final double BASE_VALUE_PER_POUND = 14.0;

    private String species = "";
    private String color = "";
    private double weight = 0.0;
    private int lengthInCM = 0;
    private double value=0;

    public Fish() {

    }

    public Fish(String species, String color, int weight, int lengthInCM) {
        this.species = species;
        this.color = color;
        this.weight = weight;
        this.lengthInCM = lengthInCM;
        calculateValue();
    }

    public void getInformation() {
        this.species = CisUtility.getInputString("Species (crab or lobster): ");
        String speciesNameValidate = this.species.trim();
        String speciesFirstLetter = speciesNameValidate.substring(0, 1).toUpperCase();
        String speciesLastLetter = speciesNameValidate.substring(1).toLowerCase();
        String speciesNameValid = speciesFirstLetter + speciesLastLetter;
        species = speciesNameValid;

        //**************************************************************************************************************
        //Donetodo 1 - manipulate the species that is entered by the user
        //Ensure that any whitespace is removed from their entry of the species (note trim can be used)
        //Ensure that the first letter is uppercase and the remainder of the species entered is set to lowercase
        //Example:  if they entered " CRab" --> your code would have the value saved as "Crab"
        //This is to be done using String methods.
        //**************************************************************************************************************

        this.weight = CisUtility.getInputDouble("Fish weight (in pounds example: 2.4): ");
        this.lengthInCM = CisUtility.getInputInt("Length in centimeters (example:  14): ");

        //**************************************************************************************************************
        //DoneTODO 2 - use String functionality to enhance the color entry
        //Check the color entered by the user.
        //If it contains "green" then set this.color to green.
        //If it contains "blue" then set this.color to blue
        //If it contains "black" then set this.color to black.
        //**************************************************************************************************************
        //This will handle the times when the user enters something like "baby blue" for the color.
        //Example:  Even though they entered something like "baby blue" it will be processed and the color will be set to "blue".
        //Example:  If the colorEntered by the user is "Midnight black" the color saved will be "black" for this fish.
        //**************************************************************************************************************

        String colorEntered = CisUtility.getInputString("Color(green, blue, or black): ");
        String colorEnteredCase = colorEntered.toLowerCase();

        //code here for #2
        if (colorEnteredCase.contains("green")){
            this.color = "Green";
        } else if (colorEnteredCase.contains("blue")) {
            this.color = "Blue";
        } else if (colorEnteredCase.contains("black")) {
            this.color = "Black";
        }

        calculateValue();
    }

    /**
     * Calculate the overall value
     *
     * @return the value
     * @author BJM
     * @since 20241029
     */
    public double calculateValue() {

        double premiumBasedOnColor = calculatePremiumBasedOnColor();
        double premiumBasedOnSpeciesAndLength = calculatePremiumBasedOnSpeciesAndLength();
        double pricePerPoundBasedOnWeight = calculatePricePerPoundBasedOnWeight();
        double overallPremium = premiumBasedOnColor + premiumBasedOnSpeciesAndLength;

        value = weight * pricePerPoundBasedOnWeight + overallPremium;

        return value;
    }

    /**
     * This method is to apply the logic to set the premium based on species and length
     *
     * @return the premium amount
     * @author your initials
     * @since the date
     */
    public double calculatePremiumBasedOnSpeciesAndLength() {
        double premium = 0;

        if (species.equalsIgnoreCase("CRAB")) {
            if (lengthInCM > 30) {
                premium = 25;
            }
        } else if (species.equalsIgnoreCase("lobster")) {
            if (lengthInCM > 25) {
                premium = 20;
            }
        }

        return premium;
    }

    /**
     * This method is to apply the logic to set the premium based color
     *
     * @return the premium based on color
     * @author your initials
     * @since the date
     */
    public double calculatePremiumBasedOnColor() {
        double premium = 0;

        switch (color) {
            case "black":
                premium = 25;
                break;
            case "blue":
                premium = 15;
                break;
        }
        return premium;
    }

    /**
     * This method is to apply the logic to set the price per pound based on weight
     *
     * @return the price per pound based on weight
     * @author your initials
     * @since the date
     */
    public double calculatePricePerPoundBasedOnWeight() {
        double pricePerPound = 0;

        if (weight < 3) {
            pricePerPound = 6;
        } else if (weight < 5) {
            pricePerPound = 8;
        } else {
            pricePerPound = 10;
        }
        return pricePerPound;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public int getLengthInCM() {
        return lengthInCM;
    }

    public double getValue() {
        return value;
    }

    public void setSpecies(String species) {
        this.species = species;
        calculateValue();
    }

    public void setColor(String color) {
        this.color = color;
        calculateValue();
    }

    public void setWeight(double weight) {
        this.weight = weight;
        calculateValue();
    }

    public void setLengthInCM(int lengthInCM) {
        this.lengthInCM = lengthInCM;
        calculateValue();
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        String output = "Fish details\n"
                + "Species: " + species + "\n"
                + "Color: " + color + "\n"
                + "Length: " + lengthInCM + "\n"
                + "Weight: " + weight + "\n"
                + "Value: " + value;
        return output;
    }

}
