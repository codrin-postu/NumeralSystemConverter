package converter;

public class NumeralConverter {

    public static String ConvertNumber(String sourceNumber, int sourceRadix, int targetRadix) {
        int hexaDecimal;
        double hexaFractional = -1;
        StringBuilder targetNumber = new StringBuilder();
        String decimalSource, fractionalSource;

        if (sourceNumber.contains(".")) {
            decimalSource = sourceNumber.substring(0, sourceNumber.indexOf("."));
            fractionalSource = sourceNumber.substring(sourceNumber.indexOf(".") + 1);

            hexaDecimal = ConvertToHexa(decimalSource, sourceRadix);
            hexaFractional = ConvertFractionalToHexa(fractionalSource, sourceRadix);

            targetNumber.append(ConvertToBase(hexaDecimal, hexaFractional, targetRadix));
        } else {
            hexaDecimal = ConvertToHexa(sourceNumber, sourceRadix);

            targetNumber.append(ConvertToBase(hexaDecimal, targetRadix));
        }

        return targetNumber.toString();
    }

    private static double ConvertFractionalToHexa(String fractionalSource, int sourceRadix) {
        double value = 0;
        for (char c : fractionalSource.toCharArray()
        ) {
            value += Character.getNumericValue(c) / Math.pow(sourceRadix, fractionalSource.indexOf(c) + 1);
        }
        return value;
    }

    private static int ConvertToHexa(String sourceNumber, int sourceRadix) {
        int hexaNumber;
        if (sourceRadix == 1) {
            hexaNumber = 0;
            int number = Integer.parseInt(sourceNumber);
            while (number >= 1) {
                hexaNumber++;
                number /= 10;
            }
        } else {
            hexaNumber = Integer.parseInt(String.valueOf(sourceNumber), sourceRadix);
        }
        return hexaNumber;
    }

    private static String ConvertToBase(int hexaNumber, int targetRadix) {
        StringBuilder targetNumber = new StringBuilder();
        if (targetRadix == 1) {
            while (hexaNumber >= 1) {
                targetNumber.append("1");
                hexaNumber--;
            }
        } else {
            targetNumber.append(Integer.toString(hexaNumber, targetRadix));
        }
        return targetNumber.toString();
    }

    private static String ConvertToBase(int hexaDecimal, double hexaFractional, int targetRadix) {
        StringBuilder targetNumber = new StringBuilder();
        if (targetRadix == 1) {
            while (hexaDecimal >= 1) {
                targetNumber.append("1");
                hexaDecimal--;
            }
        } else {
            targetNumber.append(Integer.toString(hexaDecimal, targetRadix));
        }

        targetNumber.append(".");

        //Calculating the fractional part now.
        for (int i = 0; i < 5; i++) {
            hexaFractional = hexaFractional * targetRadix;
            targetNumber.append(Integer.toString((int) hexaFractional, targetRadix));
            hexaFractional -= (int) hexaFractional;
        }

        return targetNumber.toString();
    }

}
