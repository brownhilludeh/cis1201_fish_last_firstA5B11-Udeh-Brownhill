package ca.hccis;

import ca.hccis.fish.entity.Fish;
import ca.hccis.util.CisUtility;

/**
 * Valuing application
 *
 * @author BJM
 * @since 20241029
 */

//*******************************************************************************************************
// TODO 0 - constraints for this assessment
// - 90 minutes from start
// - Resources allowed:
// --> websites starting with sam.hollandcollege.com
// --> textbook
// --> IntelliJ (without ai plugins) Examples from class can be used
// Any questions - ask instructor
//******************************************************************************************************


public class Controller {

    public static void main(String[] args) {

        System.out.println("Welcome to the CIS Valuing Application");

        final String MENU = "\nMain Menu\nOption A - add a new fish\n" +
                "Option B - show value of all fish since program starts\n" +
                "Option C - Use some String methods\n" +
                "Option X - eXit\n";
        String option = "";
        double total = 0;
        do {
            option = CisUtility.getInputString(MENU);
            switch (option.toUpperCase()) {
                case "A":
                    Fish fish = new Fish();
                    fish.getInformation();
                    fish.display();
                    total += fish.getValue();
                    break;
                case "B":
                    System.out.println("Total: " + CisUtility.toCurrency(total));
                    break;
                case "C":
                    System.out.println("Do some string work in a method");
                    workWithStrings();
                    break;
                case "X":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while(!option.equalsIgnoreCase("X"));
    }

    /**
     * Do some processing with Strings
     * @since
     * @author YOUR NAME
     */

    public static void workWithStrings(){

        String testString = CisUtility.getInputString("Enter a word");

        //**************************************************************************************************************
        //TODO 3 - Use a String method to show the length of the testString to the console
        //**************************************************************************************************************

        //code #3 here
           int  testStringLen = testString.length();
        System.out.println(testStringLen);
        //**************************************************************************************************************
        //TODO 4 - Have the user enter a number and show character from the testString at that location.
        //NOTE-example if they enter 0 it would show them the first character from the testString
        //NOTE-If the number entered is more than the length of the testString give them an error message
        //**************************************************************************************************************

        //code #4 here
        int getNumber =CisUtility.getInputInt("Enter a number");
        if (getNumber > testString.length()){
            System.out.println("Error message: Number is too large");
        }else {
            String getWordIndex = testString.substring(getNumber, (getNumber + 1));
            System.out.println(getWordIndex);
        }


        //**************************************************************************************************************
        //TODO 5 - Allow the user to enter a word and tell the user the index of the word entered by the user in the testWordString
        //created below.  If the word is not contained in the testWordString then tell them "word not found".
        //
        //Note that the testWordString will be a big string containing many commonly used English words.
        //Note you can see how the String below is created by looking at the getTestWordString method
        //**************************************************************************************************************

        String testWordString = CisUtility.getTestWordString(); //This will be a big string containing common words.
        String wordEntered = CisUtility.getInputString("Enter a common English word");

        //Add some code here for #5
        boolean isEnglishWord = testWordString.contains(wordEntered);
        if (isEnglishWord) {
            int wordEnteredIndex = testWordString.indexOf(wordEntered); ;
            System.out.println(wordEnteredIndex);
        }else {
            System.out.println("Word not found");
        }
         }
}
