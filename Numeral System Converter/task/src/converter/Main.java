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

        if (sourceRadix > 36 || sourceRadix < 1 || targetRadix > 36 || targetRadix < 1) {
            System.out.println("Error: Not a valid radix!");
            return;
        }



        String targetNumber = NumeralConverter.ConvertNumber(sourceNumber, sourceRadix, targetRadix);

        System.out.println(targetNumber);

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
