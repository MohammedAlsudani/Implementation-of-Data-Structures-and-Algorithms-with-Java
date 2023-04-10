package practice;

public class ReversStringExercise {

    public static void main (String[] args) {
        String str2 = "Hi my name is mohammed";
        System.out.println("reversWithSimpleLoop = " + reversWithSimpleLoop(str2));
        System.out.println("reversWithBytes = " + reversWithBytes(str2));
        System.out.println("reversWithCharArray = " + reversWithCharArray(str2));

    }

    private static String reversWithSimpleLoop(String str) {
        String reversedString = "";
        for (int i = 0; i < str.length(); i++) {
            reversedString = str.charAt(i) + reversedString; //adds each character in front of the existing string
        }
        return reversedString;
    }

    private static String reversWithBytes(String str) {
        // getBytes method to convert string to bytes
        byte [] stringByteArray = str.getBytes();
        byte [] result = new byte[stringByteArray.length];
        // store result in reversed order into result byte
        for (int i = 0; i < str.length();i++){
            result[i] = stringByteArray[stringByteArray.length - i-1];
        }
        return new String(result);
    }

    private static String reversWithCharArray(String str) {
        // convert string to chart array
        String result ="";
        char[] stringChartArray = str.toCharArray();
        for (int i = stringChartArray.length-1 ; i > 0; i--){
            result = result + stringChartArray[i];
        }
        return result;
    }

}
