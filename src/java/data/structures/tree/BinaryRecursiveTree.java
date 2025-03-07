package data.structures.tree;

import data.structures.stack.SinglyLinkedListStack;
import data.structures.tree.node.BinaryTreeNode;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Iterator;


public class BinaryRecursiveTree<T extends Comparable<? super T>>
        implements BinaryTreeNode<T>, Comparable<BinaryRecursiveTree<T>>
{
    //# Fields
    private final T data;
    private BinaryRecursiveTree<T> left = null;
    private BinaryRecursiveTree<T> right = null;


    //# Constructors
    public BinaryRecursiveTree(T root) {
        this.data = root;
    }


    //# Getter-methods
    public T getData() {
        return this.data;
    }

    public BinaryRecursiveTree<T> getLeft() {
        return this.left;
    }

    public BinaryRecursiveTree<T> getRight() {
        return this.right;
    }

    public T getLowestValue(BinaryRecursiveTree<T> node) {
        return this.getLowestValueNode(node).getData();
    }

    public BinaryRecursiveTree<T> getLowestValueNode(BinaryRecursiveTree<T> node) {
        if (node.left == null) {
            return node;
        }
        else {
            return this.getLowestValueNode(node.left);
        }
    }

    public T getHighestValue() {
        return this.getHighestValueNode(this).getData();
    }

    protected T getHighestValue(BinaryRecursiveTree<T> node) {
        return this.getHighestValueNode(node).getData();
    }

    public BinaryRecursiveTree<T> getHighestValueNode() {
        return this.getHighestValueNode(this);
    }

    public BinaryRecursiveTree<T> getHighestValueNode(BinaryRecursiveTree<T> node) {
        if (node.right == null) {
            return node;
        }
        else {
            return this.getHighestValueNode(node.right);
        }
    }


    //# Setter-methods
    public void add(T element) {

    }

    //# Insertion
    public BinaryRecursiveTree<T> insert(T element) {
        return this.insert(this, element);
    }

    public BinaryRecursiveTree<T> insert(BinaryRecursiveTree<T> tree, T element) {
        if (tree == null) {
            return new BinaryRecursiveTree<>(element);
        }

        var comparison = tree.data.compareTo(element);

        if (comparison != 0) {
            if  (0 > comparison) {
                tree.left = this.insert(tree.left, element);
            }

            if (comparison > 0) {
                tree.right = this.insert(tree.right, element);
            }
        }

        return tree;
    }


    //# Traversal
    public Iterator<T> preOrderIterator() {
        var stack = new SinglyLinkedListStack<BinaryRecursiveTree<T>>();

        this.traverseLeft(stack::push);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                var output = stack.pop();

                if (output.right != null) {
                    stack.push(output.right);
                }

                if (output.left != null) {
                    if (!stack.isEmpty() && stack.peek().left != output) {
                        stack.push(output.left);
                    }
                    else if (stack.isEmpty()) {
                        stack.push(output.left);
                    }
                }

                return output.getData();
            }
        };
    }

    private void traverseLeft(Consumer<BinaryRecursiveTree<T>> consumer) {
        var node = this;

        while (node != null) {
            consumer.accept(node);

            node = node.left;
        }
    }


    //# Search
    public boolean search(Predicate<BinaryRecursiveTree<T>> condition) {
        return false;
    }
    public BinaryRecursiveTree<T> find(Predicate<BinaryRecursiveTree<T>> condition) {
        return null;
    }





    //# Overrides
    @Override
    public int compareTo(BinaryRecursiveTree<T> node) {
        return this.getData().compareTo(node.getData());
    }
}
