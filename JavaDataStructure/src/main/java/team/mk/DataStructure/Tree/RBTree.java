package team.mk.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class RBTree<T extends Comparable<? super T>> implements Tree<T> {

    private RBNode root;

    private class RBNode extends BinaryNode<T> {

    }

    public RBTree() {
        root = null;
    }

    public boolean isEmpty() {
        return false;
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

    public RBNode findNode() {
        return null;
    }

    public RBNode getRoot() {
        return this.root;
    }

    public boolean contains(T data) throws Exception {
        return false;
    }

    public void clear() {

    }
}
