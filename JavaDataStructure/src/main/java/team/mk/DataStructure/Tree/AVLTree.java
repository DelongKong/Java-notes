package team.mk.DataStructure.Tree;

import java.util.ArrayList;

public class AVLTree<T extends Comparable<? super T>> implements Tree<T>{

    private AVLNode root;

    private class AVLNode extends BinaryNode<T> {
        private int height;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public AVLTree() {
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

    public AVLNode findNode() {
        return null;
    }

    public AVLNode getRoot() {
        return this.root;
    }

    public boolean contains(T data) throws Exception {
        return false;
    }

    public void clear() {

    }
}
