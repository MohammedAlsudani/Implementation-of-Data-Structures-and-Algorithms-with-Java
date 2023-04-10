package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class ArrayPractice {

    public static void main(String[] args) {
        ArrayList<String> thisArrayList = new ArrayList<>();
        thisArrayList.add("hello");
        thisArrayList.add("world");
        String[] strings = new String[]{"hello", "world"};
        System.out.println(strings[0]);
        System.out.println(thisArrayList.get(0));
    }

}
