package team.mk.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public interface Tree<T extends Comparable<? super T>> {
    boolean isEmpty();
    int size();
    int height();
    String preOrder();
    String inOrder();
    String postOrder();
    String levelOrder();
    void insert(T data);
    void remove(T data);
    T findMin();
    T findMax();
    BinaryNode findNode();
    BinaryNode getRoot();
    boolean contains(T data) throws Exception;
    void clear();

}
