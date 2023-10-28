package org.example;
import org.apache.commons.math3.util.Precision;

public class App 
{
    public static void main( String[] args ) {
        double number = 3.14159265359;
        int decimalPlaces = 2;
        double rounded = Precision.round(number, decimalPlaces);
        System.out.println("Número arredondado: " + rounded);

    }
}
