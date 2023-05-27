package Tree.part2;


public class BinarySearchTrees {
    private TreeNode root;

    public BinarySearchTrees() {
        this.root = null;
    }

    public void insert(int value){
        TreeNode newTreeNode =new TreeNode(value);
        if (root == null){
            this.root = newTreeNode;
        } else {
            TreeNode currentNode = this.root;
            while (true){
                if (value < currentNode.getData()) {
                    //Left
                    if (currentNode.getLeftChild() == null){
                        currentNode.setLeftChild(newTreeNode);
                        return;
                    }
                    currentNode = currentNode.getLeftChild();
                } else {
                    //Right
                    if (currentNode.getRightChild() == null){
                        currentNode.setRightChild(newTreeNode);
                        return;
                    }
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    public TreeNode lookup(int value) {
        if (this.root != null) {
            TreeNode currentNode = this.root;
            while (true) {
                //left
                if (value < currentNode.getData()){
                    currentNode = currentNode.getLeftChild();
                } else if (value > currentNode.getData()){
                    currentNode = currentNode.getRightChild();
                } else {
                    return currentNode;
                }
                if (currentNode == null){
                    return null;
                }
            }
        }
        return null;
    }

    public void remove(int value) {
        if (this.root == null) {
            return;
        }
        TreeNode currentNode = this.root;
        TreeNode parentNode = null;
        while (currentNode != null) {
            if (value < currentNode.getData()){
                parentNode = currentNode;
                currentNode = currentNode.getLeftChild();
            }else if (value > currentNode.getData()){
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
            } else {
                //We have a match, get to work!
                //Option 1: No right child:
                if (currentNode.getRightChild() == null) {
                    if (parentNode == null){
                        this.root = currentNode.getLeftChild();
                    } else {
                        //if parent > current value, make current left child a child of parent
                        if (currentNode.getData() < parentNode.getData()){
                            parentNode.setLeftChild(currentNode.getLeftChild());
                        }
                        //if parent < current value, make left child a right child of parent
                        else if (currentNode.getData() > parentNode.getData()){
                            parentNode.setRightChild(currentNode.getLeftChild());
                        }
                    }
                }
                //Option 2: Right child which doesn't have a left child
                else if (currentNode.getRightChild().getLeftChild() == null){
                    currentNode.getRightChild().setLeftChild(currentNode.getLeftChild());
                    if (parentNode == null){
                        this.root = currentNode.getRightChild();
                    }else {
                        //if parent > current, make right child of the left the parent
                        if(currentNode.getData() < parentNode.getData()) {
                            parentNode.setLeftChild(currentNode.getRightChild());
                            //if parent < current, make right child a right child of the parent
                        } else if (currentNode.getData() > parentNode.getData()) {
                            parentNode.setRightChild(currentNode.getRightChild());
                        }
                    }
                }
                //Option 3: Right child that has a left child
                else {
                    //find the Right child's leftmost child
                    TreeNode leftmost = currentNode.getRightChild().getLeftChild();
                    TreeNode leftmostParent = currentNode.getRightChild();
                    while(leftmost.getLeftChild() != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.getLeftChild();
                    }
                    //Parent's left subtree is now leftmost's right subtree
                    leftmostParent.setLeftChild(leftmost.getRightChild());
                    leftmost.setLeftChild(currentNode.getLeftChild());
                    leftmost.setRightChild(currentNode.getRightChild());
                    if(parentNode == null) {
                        this.root = leftmost;
                    } else {
                        if(currentNode.getData() < parentNode.getData()) {
                            parentNode.setLeftChild(leftmost);
                        } else if(currentNode.getData() > parentNode.getData()) {
                            parentNode.setRightChild(leftmost);
                        }
                    }
                }
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTrees{" +
                "root=" + root +
                '}';
    }
}
