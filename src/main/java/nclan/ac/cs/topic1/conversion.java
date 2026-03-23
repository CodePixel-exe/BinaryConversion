package nclan.ac.cs.topic1;

import static nclan.ac.cs.topic1.conversion.runConversion;
import static nclan.ac.cs.topic1.representation.runASCII;

public class conversion {
    public static void main(String[] args) {
        System.out.println("Conversion test program");
        runConversion();
        representation.runASCII();
        runBitwiseLogic();
        runSubtraction();
    }

    public static String convertDecimalToBinary(int number) {

        return padLeftZeros(Integer.toString(number, 2));
    }

    public static String convertDecimalToHex(int number) {
        return Integer.toString(number, 16).toUpperCase();

    }

    public static String convertHexToBinary(int number){
        return Integer.toString(number, 2);
    }
    public static String convertBinaryToHex(int number){
        return Integer.toString(number, 16);
    }

    public static int convertBinaryToDecimal(String number) {
        return Integer.parseInt(number, 2);
    }

    public static int convertHexToDecimal(String number) {
        return Integer.parseInt(number, 16);
    }

    public static void runConversion() {
        System.out.println(convertDecimalToBinary(12));
        System.out.println(convertDecimalToHex(62493));
        System.out.println(convertBinaryToDecimal("0011"));
        System.out.println(convertHexToDecimal("132A"));
    }

    public static void runSubtraction(){
        try {
            String result = binarySubtract.subtractBinary("1010", "1011");
            System.out.println("Binary Subtraction Result: " + result);
            String resultHex = binarySubtract.subtractHex("1AF", "4FA");
            System.out.println("Hexadecimal Subtraction result: " + resultHex);
        }catch (Exception e){
            System.err.println("Failed to subtract." + e.getMessage());
        }
    }

    public static String padLeftZeros(String inputString) {
        int length = 8;
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(0);
        }
        sb.append(inputString);
        return sb.toString();
    }

    /**Bitwise Logic Run method
     * Runs the bitwise logic and displays results in console
     */
    private static void runBitwiseLogic(){
    try{
        //AND operator
        String result = BitWiseLogic.binaryAND("10101010","11110000");
        System.out.println("(AND) Result: "+ result);
        //OR operator
        String resultOR = BitWiseLogic.binaryOR("10101010","11110000");
        System.out.println("(OR) Result: " + resultOR);
        //XOR operator
        String resultXOR = BitWiseLogic.binaryXOR("10101110","11110000");
        System.out.println("(XOR) Result: " + resultXOR);
    }catch (Exception e)
    {
        System.err.println("Binary operator Failed. " + e.getMessage());
    }

}

}


