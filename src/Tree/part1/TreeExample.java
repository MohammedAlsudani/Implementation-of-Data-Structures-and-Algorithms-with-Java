package Tree.part1;

public class TreeExample {

    public static void main(String[] args) {
        int[] inputArray = {57, 58, 59, -22, 7, 60, 61, 62, 20, 35, 55, -14, 1, 56};

        Tree intTree = new Tree();
        for (int j : inputArray) {
            intTree.insert(j);
        }
        intTree.traverseInOrder();
        System.out.println();

        System.out.println(intTree.get(61));
        System.out.println(intTree.get(7));
        System.out.println(intTree.get(1));
        System.out.println(intTree.get(555));

        System.out.println("min = " + intTree.min());
        System.out.println("max = " + intTree.max());


        intTree.delete(17);
        intTree.delete(-22);
        intTree.delete(60);
        intTree.delete(17);
        intTree.traverseInOrder();
        System.out.println();
        intTree.traversePreOrder();
        System.out.println();
        intTree.traversePostOrder();
    }
}
