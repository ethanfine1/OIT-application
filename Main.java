public class Main {
    public static void main(String[] args) {

	    int finalVal = 0;

	    char[] numerals = new char[args[0].length()];

	    for (int i = 0; i < args[0].length(); i++){
	        numerals[i] = args[0].charAt(i);
        }

	    if(Character.isDigit(numerals[0])){
	        int decimal = Integer.parseInt(new String(numerals));

	        StringBuilder finalNumerals = new StringBuilder();

            while(decimal != 0){
                if(decimal >= 1000){
                    decimal -= 1000;
                    finalNumerals.append("M");
                }
                else if (decimal >= 900){
                    decimal -= 900;
                    finalNumerals.append("CM");
                }
                else if(decimal >= 500){
                    decimal -= 500;
                    finalNumerals.append("D");
                }
                else if (decimal >= 400){
                    decimal -= 400;
                    finalNumerals.append("CD");
                }
                else if(decimal >= 100){
                    decimal -= 100;
                    finalNumerals.append("C");
                }
                else if (decimal >= 90){
                    decimal -= 90;
                    finalNumerals.append("XC");
                }
                else if(decimal >= 50){
                    decimal -= 50;
                    finalNumerals.append("L");
                }
                else if(decimal >= 40){
                    decimal -= 40;
                    finalNumerals.append("XL");
                }
                else if(decimal >= 10){
                    decimal -= 10;
                    finalNumerals.append("X");
                }
                else if(decimal == 9){
                    decimal -= 9;
                    finalNumerals.append("IX");
                }
                else if(decimal >= 5){
                    decimal -= 5;
                    finalNumerals.append("V");
                }
                else if (decimal == 4){
                    decimal -= 4;
                    finalNumerals.append("IV");
                }
                else if(decimal >= 1){
                    decimal -= 1;
                    finalNumerals.append("I");
                }
            }

            System.out.println("The number as a roman numeral is " + finalNumerals.toString());
        }
        else {
            if (numerals.length % 2 == 0) {
                for (int i = 0; i < numerals.length - 1; i++) {
                    int ascii = numerals[i];
                    int ascii2 = numerals[i + 1];

                    int decimal = getDecimal(ascii);
                    int decimal2 = getDecimal(ascii2);

                    if (decimal < decimal2 / 10) {
                        System.out.println("INVALID NUMERAL");
                        return;
                    }

                    if (decimal < decimal2) {
                        finalVal += (decimal2 - decimal);
                    } else {
                        finalVal += (decimal + decimal2);
                    }
                    i++;
                }
            }
            else {
                int ascii0 = numerals[0];
                int decimal0 = getDecimal(ascii0);

                for (int i = 1; i < numerals.length - 1; i++) {
                    int ascii = numerals[i];
                    int ascii2 = numerals[i + 1];

                    int decimal = getDecimal(ascii);
                    int decimal2 = getDecimal(ascii2);

                    if (decimal < decimal2 / 10) {
                        System.out.println("INVALID NUMERAL");
                        return;
                    }

                    if (decimal < decimal2) {
                        finalVal += (decimal2 - decimal);
                    } else {
                        finalVal += (decimal + decimal2);
                    }
                    i++;
                }
                finalVal += decimal0;
            }
            System.out.println("These numerals are equal to " + finalVal);
        }
    }

    public static int getDecimal(int ascii){
        int I = 73;
        int V = 86;
        int X = 88;
        int L = 76;
        int C = 67;
        int D = 68;
        int M = 77;
        int decimal = 0;
        if(ascii == I){
            decimal = 1;
        }
        if(ascii == V){
            decimal = 5;
        }
        if(ascii == X){
            decimal = 10;
        }
        if(ascii == L){
            decimal = 50;
        }
        if(ascii == C){
            decimal = 100;
        }
        if(ascii == D){
            decimal = 500;
        }
        if(ascii == M){
            decimal = 1000;
        }
        return decimal;
    }

}
