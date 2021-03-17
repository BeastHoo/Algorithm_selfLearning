package BinarySearchTree;

public class Node {
    private int key;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int key) {
        this.key = key;
        left=null;
        right=null;
        parent=null;
    }

    public Node() {
        this.key=Integer.MIN_VALUE;
        left=null;
        right=null;
        parent=null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
