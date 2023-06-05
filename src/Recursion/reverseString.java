package Recursion;

public class reverseString {

    public static void main(String[] args) {
        String str = "yoyo yoyo";
        System.out.println(reversedString(str));
        System.out.println(reversedRecursivelyString(str));
    }

    private static String reversedString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }

    private static String reversedRecursivelyString(String str) {
        if (str.equals("")) {
            return str;
        } else {
            return reversedRecursivelyString(str.substring(1)) + str.charAt(0);
        }
    }
}
