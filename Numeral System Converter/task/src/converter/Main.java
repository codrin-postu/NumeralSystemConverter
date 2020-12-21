package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sourceRadix, targetRadix;

        if (scan.hasNextInt()) {
            sourceRadix = scan.nextInt();
        } else {
            System.out.println("Error: Not a number!");
            return;
        }
        String sourceNumber = scan.next();
        if (scan.hasNextInt()) {
            targetRadix = scan.nextInt();
        } else {
            System.out.println("Error: Not a number!");
            return;
        }

       if (!VerifyInput(sourceNumber,sourceRadix,targetRadix)) return;


        String targetNumber = NumeralConverter.ConvertNumber(sourceNumber, sourceRadix, targetRadix);

        System.out.println(targetNumber);

    }

    private static boolean  VerifyInput(String sourceNumber,int sourceRadix,int targetRadix){
        if (sourceRadix > 36 || sourceRadix < 1 || targetRadix > 36 || targetRadix < 1) {
            System.out.println("Error: Not a valid radix!");
            return false;
        }

        for (char c : sourceNumber.toCharArray()
             ) {
                if (Character.getNumericValue(c) >= sourceRadix) {
                    System.out.println("Error: Not a valid number!");
                    return false;
                }
        }

        return true;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
