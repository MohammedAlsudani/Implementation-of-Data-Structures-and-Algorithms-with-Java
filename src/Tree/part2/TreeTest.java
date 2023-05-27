package Tree.part2;

import com.google.gson.Gson;

public class TreeTest {

    public static void main(String[] args) {
        BinarySearchTrees binarySearchTrees = new BinarySearchTrees();
        binarySearchTrees.insert(9);
        binarySearchTrees.insert(4);
        binarySearchTrees.insert(6);
        binarySearchTrees.insert(20);
        binarySearchTrees.insert(170);
        binarySearchTrees.insert(15);
        binarySearchTrees.insert(1);



        System.out.println("binarySearchTrees = " + new Gson().toJson(binarySearchTrees));

        System.out.println("binarySearchTrees lookup = " + binarySearchTrees.lookup(4));
        binarySearchTrees.remove(4);
        System.out.println("binarySearchTrees lookup = " + binarySearchTrees.lookup(4));
        System.out.println("binarySearchTrees2 = " + new Gson().toJson(binarySearchTrees));

    }
}
