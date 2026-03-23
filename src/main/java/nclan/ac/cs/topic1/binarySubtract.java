package nclan.ac.cs.topic1;

public class binarySubtract {
    public static String subtractBinary(String bin1, String bin2){
        int num1 = conversion.convertBinaryToDecimal(bin1);
        int num2 = conversion.convertBinaryToDecimal(bin2);
        return conversion.convertDecimalToBinary(num1 - num2);
    }
    public static String subtractHex(String hx1, String hx2){
        int num1 = conversion.convertHexToDecimal(hx1);
        int num2 = conversion.convertHexToDecimal(hx2);
        return conversion.convertDecimalToHex(num1 - num2);
    }

}
