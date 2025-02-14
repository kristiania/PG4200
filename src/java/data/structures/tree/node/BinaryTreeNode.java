package data.structures.tree.node;

public interface BinaryTreeNode<T> {
    BinaryTreeNode<T> getLeft();
    BinaryTreeNode<T> getRight();
    T getData();
}
