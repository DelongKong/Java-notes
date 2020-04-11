package team.mk.DataStructure.Tree;

import java.util.List;

public class BSTree<T extends Comparable<? super T>> implements Tree<T>{

    private BSNode root;

    private class BSNode extends BinaryNode<T> {

    }

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root==null;
    }

    public int size() {
        return 0;
    }

    public int height() {
        return 0;
    }

    public String preOrder() {
        return null;
    }

    public String inOrder() {
        return null;
    }

    public String postOrder() {
        return null;
    }

    public String levelOrder() {
        return null;
    }

    public void insert(T data) {

    }

    public void remove(T data) {

    }

    public T findMin() {
        return null;
    }

    public T findMax() {
        return null;
    }

    public BSNode findNode() {
        return null;
    }

    public BSNode getRoot() {
        return this.root;
    }

    public boolean contains(T data) throws Exception {
        return false;
    }

    public void clear() {

    }
}
