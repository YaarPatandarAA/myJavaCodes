/* 
 * Name:       Jaswinder Pal Singh
 *
 * Course:     CSC 130
 * 
 * Date:       10/15/2017
 * 
 * Filename:   AvlNode.java
 * 
 * Purpose:    All attributes of a node of the AVLTREE
 */

public class AvlNode {
    private int value;
    private AvlNode left;
    private AvlNode right;
    private int height;
    public AvlNode(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public AvlNode getLeft() {
        return left;
    }
    public void setLeft(AvlNode left) {
        this.left = left;
    }
    public AvlNode getRight() {
        return right;
    }
    public void setRight(AvlNode right) {
        this.right = right;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}