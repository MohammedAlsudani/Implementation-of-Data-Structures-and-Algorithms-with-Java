package Tree.part2;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

        System.out.println("breadthFirstSearch = " + binarySearchTrees.breadthFirstSearch());
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(binarySearchTrees.getRoot());
        System.out.println("breadthFirstSearch R = " + binarySearchTrees.breadthFirstSearchR(list, queue));
    }
}
