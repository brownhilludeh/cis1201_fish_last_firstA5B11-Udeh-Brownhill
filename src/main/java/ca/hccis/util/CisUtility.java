package ca.hccis.util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * Has some useful methods to be used in our programs.
 *
 * @author bjmaclean
 * @since Oct 19, 2021
 */
public class CisUtility {

    private static Scanner input = new Scanner(System.in);

    private static String testWordString = "the, be, to, of, and, a, in, that, have, I, it, for, not, on, with, he, as, " +
            "you, do, at, this, but, his, by, from, they, we, say, her, she, or, an, will, my, one, all, would, there, their," +
            " what, so, up, out, if, about, who, get, which, go, me, when, make, can, like, time, no, just, him, know, take, " +
            "people, into, year, your, good, some, could, them, see, other, than, then, now, look, only, come, its, over, " +
            "think, also, back, after, use, two, how, our, work, first, well, way, even, new, want, because, any, these, give, " +
            "day, most, us, is, was, were, has, are, been, where, did, more, had, such, being, much, many, each, may, every, " +
            "though, while, through, during, always, better, never, still, until, since, yet, least, best, known, between, against, " +
            "same, thought, without, within, often, once, few, around, above, below, whether, though, might, almost, herself, " +
            "himself, among, along, behind, ahead, across, another, something, anything, everything, nothing, anyone, someone, " +
            "everyone, themselves, ourselves, myself, herself, himself, anywhere, everywhere, nowhere, beside, besides, underneath, " +
            "inside, outside, beyond, upon, underneath, instead, however, although, moreover, therefore, perhaps, actually, " +
            "probably, generally, specifically, differently, directly, quickly, slowly, simply, clearly, suddenly, finally, " +
            "currently, certainly, fortunately, obviously, necessarily, importantly, possibly, rarely, barely, widely, truly";

    public static String getTestWordString(){
        return testWordString;
    }
    /**
     * Return the default currency String value of the double passed in as a
     * parameter.
     *
     * @param inputDouble double to be formatted
     * @return String in default currency format
     *
     * @since 20211020
     * @author BJM
     */
    public static String toCurrency(double inputDouble) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(inputDouble);
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return String entered by the user
     * @since 20211020
     * @author BJM
     */
    public static String getInputString(String prompt) {

        System.out.println(prompt + " -->");
        String output = input.nextLine();
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @since 20211020
     * @author BJM
     */
    public static double getInputDouble(String prompt) {

        String inputString = getInputString(prompt);
        double output = Double.parseDouble(inputString);
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @since 20211020
     * @author BJM
     */
    public static int getInputInt(String prompt) {

        String inputString = getInputString(prompt);
        int output = Integer.parseInt(inputString);
        return output;
    }

     /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @since 20211108
     * @author BJM
     */
    public static boolean getInputBoolean(String prompt) {

        String inputString = getInputString(prompt+" (y/n)");
        if(inputString.equalsIgnoreCase("y")){
            return true;
        }else{
            return false;
        }
        
    }

     /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @since 20211108
     * @author BJM
     */
    public static boolean getInputBoolean(String prompt, String affirmative, String negative) {

        String inputString = getInputString(prompt+" ("+affirmative+"/"+negative+")");
        if(inputString.equalsIgnoreCase(affirmative)){
            return true;
        }else{
            return false;
        }
        
    }


    
    /**
     * Provide today's date in the specified format
     *
     * @param format Date format desired
     * @return Today's date in specified format
     * @since 20211021
     * @author BJM
     */
    public static String getTodayString(String format) {
        //https://www.javatpoint.com/java-get-current-date

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

        /**
     * Get a random number between min and max
     * @since 20211109
     * @author BJM
     */
    public static int getRandom(int min, int max){
        Random rand = new Random();
        int theRandomNumber = rand.nextInt((max - min) + 1) + min;
        return theRandomNumber;
    }
    
    
}
