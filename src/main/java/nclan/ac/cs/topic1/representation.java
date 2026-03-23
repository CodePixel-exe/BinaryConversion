package nclan.ac.cs.topic1;

public class representation {
    public static int charToASCII(char singleChar) {
        return singleChar;
    }

    public static void runASCII() {
        System.out.println("Character in ASCII:");
        System.out.println(representation.charToASCII('A'));
        System.out.println(representation.stringToASCII("Hi"));
        System.out.println(representation.stringToHex("Hello!"));
        System.out.println(representation.decimalToString("67 68"));
        System.out.println(representation.decimalToChar(163));
    }

    static public String stringToASCII(String manyChars) {
        char[] arrayChars = manyChars.toCharArray();
        StringBuilder returnValues = new StringBuilder();
        String result = null;
        for (char c : arrayChars) {
            returnValues.append(charToASCII(c)).append(" ");
            result = returnValues.toString();
        }

        return result;
    }

    static public String stringToHex(String manyChars) {
        char[] arrayChars = manyChars.toCharArray();
        StringBuilder returnValues = new StringBuilder();
        for (char c : arrayChars) {
            int val = (int) c;
            String strVal = Integer.toHexString(val).toUpperCase();
            returnValues.append(strVal).append(" ");


        }
        return returnValues.toString();
    }

    public static char decimalToChar(int val){
        return (char) val;
    }

    static public String decimalToString(String strOfInts) {

        StringBuilder returnValues = new StringBuilder();
        //Stores in an array and gets rid of empty characters by using .trim and spliting them in order to be converted later
        String[] arrayChars = strOfInts.trim().split("\\s+");
        for (String num : arrayChars) {
            int val = Integer.parseInt(num);
            returnValues.append((char)val);


        }
        return returnValues.toString();

    }
}





