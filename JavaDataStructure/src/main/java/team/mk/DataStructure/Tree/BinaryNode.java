package team.mk.DataStructure.Tree;

import java.io.Serializable;

public abstract class BinaryNode<T extends Comparable<? super T>> implements Serializable {
    private T data;

    private BinaryNode<T> left;

    private BinaryNode<T> right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode() {}

    public T getData() {
        return data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left==null && this.right==null;
    }
}
