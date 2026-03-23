package nclan.ac.cs.topic1;

public class BitWiseLogic {
    public static String binaryAND(String val1, String val2){
        int num1 = conversion.convertBinaryToDecimal(val1);
        int num2 = conversion.convertBinaryToDecimal(val2);
        int result = num1 & num2;

        return conversion.convertDecimalToBinary(result);
    }
    public static String binaryOR(String val1, String val2){
        int num1 = conversion.convertBinaryToDecimal(val1);
        int num2 = conversion.convertBinaryToDecimal(val2);
        int result = num1 | num2;

        return conversion.convertDecimalToBinary(result);
    }
    public static String binaryXOR(String val1, String val2){
        int num1 = conversion.convertBinaryToDecimal(val1);
        int num2 = conversion.convertBinaryToDecimal(val2);
        int result = num1 ^ num2;

        return conversion.convertDecimalToBinary(result);
    }

}
