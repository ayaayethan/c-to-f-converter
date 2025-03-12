package edu.csumb.cst_338;

/**
 * A utility class for unity conversions of Celsius to Fahrenheit and vise versa
 */
public class Utils {
    public static double ctof(double celsius) {
        return (celsius * 1.8) + 32;
    }

    public static double ftoc(double fahrenheit) {
        return (fahrenheit * 1.8) + 32;
    }
}
