package data.structures.tree;

import data.structures.tree.node.BinaryTreeNode;

import java.util.Iterator;
import java.util.function.Consumer;


public interface BinaryTreeImplementation<T extends Comparable<? super T>>
        extends TreeImplementation<T, BinaryTreeNode<T>>
{
    //# Insertion
    BinaryTreeNode<T> insert(T value);

    //# Deletion
    void delete(T value);

    //# Traversal
    Iterator<BinaryTreeNode<T>> preOrderIterator();
    Iterator<BinaryTreeNode<T>> inOrderIterator();
    Iterator<BinaryTreeNode<T>> postOrderIterator();
    void preOrderTraversal(Consumer<BinaryTreeNode<T>> consumer);


    //# Search
    boolean search(T value);
    BinaryTreeNode<T> findNode(T value);
}
