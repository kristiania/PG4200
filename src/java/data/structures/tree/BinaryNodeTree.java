package data.structures.tree;

import data.structures.Wrapper;
import data.structures.tree.node.BinaryTreeNode;
import data.structures.stack.SinglyLinkedListStack;

import java.util.Iterator;
import java.util.function.Consumer;


/**
 *
 * @param <T>
 */
public class BinaryNodeTree<T extends Comparable<? super T>>
        implements BinaryTreeImplementation<T>
{
    //# Fields
    private Node root = null;


    //# BinaryNodeTree::Node
    public class Node
            implements BinaryTreeNode<T>, Comparable<Node>
    {
        private final T data;
        private Node left;
        private Node right;

        private Node(T data) {
            this.data  = data;
        }

        public T getData() {
            return this.data;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public Iterator<Node> leftIterator() {
            var node = this;

            return new Iterator<Node>() {
                @Override
                public boolean hasNext() {
                    return node.getLeft() != null;
                }

                @Override
                public Node next() {
                    return node.getLeft();
                }
            };
        }

        public Iterator<Node> rightIterator() {
            var node = this;

            return new Iterator<Node>() {
                @Override
                public boolean hasNext() {
                    return node.getRight() != null;
                }

                @Override
                public Node next() {
                    return node.getRight();
                }
            };
        }

        @Override
        public int compareTo(Node node) {
            return this.data.compareTo(node.data);
        }
    }


    //# Constructors
    public BinaryNodeTree() {}

    public BinaryNodeTree(T data) {
        this.root = this.createNode(data);
    }


    //# Getter-methods
    public Node getRoot() {
        return this.root;
    }

    public Node createNode(T data) {
        return this.new Node(data);
    }


    //# Insertions
    @Override
    public BinaryTreeNode<T> insert(T data) {
        return this.insert(this.createNode(data));
    }

    public BinaryTreeNode<T> insert(Node node) {
        if (this.root == null) {
            this.root = node;

            return node;
        }
        else {
            return this.insert(this.root, node);
        }
    }

    private BinaryTreeNode<T> insert(Node root, Node node) {
        int comparison = root.compareTo(node);

        if (comparison != 0) {
            // root node is larger than node given
            if (comparison > 0) {
                if  (root.left != null) {
                    return this.insert(root.left, node);
                }
                else {
                    root.left = node;
                }
            }
            // root node is less than node given
            else {
                if (root.right != null) {
                    return this.insert(root.right, node);
                }
                else {
                    root.right = node;
                }
            }
        }

        return node;
    }


    //# Deletion
    public void delete(T data) {

    }


    //# Traversal
    @Override
    public Iterator<T> iterator() {
        var iterator = this.preOrderIterator();

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next().getData();
            }
        };
    }

    public Iterator<Node> leftIterator() {
        return this.getRoot().leftIterator();
    }

    public Iterator<Node> rightIterator() {
        return this.getRoot().rightIterator();
    }

    public void traverseLeft(Consumer<Node> consumer) {
        var iterator = this.leftIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public void traverseRight(Consumer<Node> consumer) {
        var iterator = this.rightIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public Iterator<BinaryTreeNode<T>> preOrderIterator() {
        var stack = new SinglyLinkedListStack<Node>();

        stack.push(this.getRoot());

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Node next() {
                var output = stack.pop();

                if (output.right != null) {
                    stack.push(output.right);
                }

                if (output.left != null) {
                    stack.push(output.left);
                }

                return output;
            }
        };
    }

    public void preOrderTraversal(Consumer<BinaryTreeNode<T>> consumer) {
        var iterator = preOrderIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public Iterator<BinaryTreeNode<T>> inOrderIterator() {
        var stack = new SinglyLinkedListStack<Node>();
        final var node = new Wrapper<>(this.root);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return node.get() != null || !stack.isEmpty();
            }

            @Override
            public Node next() {
                while (node.get() != null) {
                    stack.push(node.get());

                    node.set(node.get().getLeft());
                }

                var output = stack.pop();

                node.set(output.getRight());

                return output;
            }
        };
    }

    public void inOrderTraversal(Consumer<BinaryTreeNode<T>> consumer) {
        var iterator = this.inOrderIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public Iterator<BinaryTreeNode<T>> postOrderIterator() {
        var stack = new SinglyLinkedListStack<Node>();
        final var node = new Wrapper<>(this.getRoot());
        final var lastNodeVisited = new Wrapper<Node>(this.getRoot());

        Consumer<Node> traverseTree = (tree) -> {
            while (node.get() != null) {
                stack.push(node.get());

                node.set(node.get().getLeft());
            }
        };

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return node.get() != null || !stack.isEmpty();
            }

            @Override
            public Node next() {
                while (node.get() != null) {
                    stack.push(node.get());

                    node.set(node.get().getLeft());
                }

                var output = stack.peek();

                if (output.getRight() != null && lastNodeVisited.get() != output.getRight()) {
                    node.set(output.getRight());

                    return this.next();
                }

                lastNodeVisited.set(stack.pop());

                return output;
            }
        };
    }

    public void postOrderTraversal(Consumer<BinaryTreeNode<T>> consumer) {
        var iterator = this.postOrderIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public void forEach(Iterator<BinaryTreeNode<T>> iterator, Consumer<BinaryTreeNode<T>> consumer) {
        while(iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }


    //# Search
    public boolean search(T value) {
        var iterator = this.inOrderIterator();

        while (iterator.hasNext()) {
            var node = iterator.next();

            if (node.getData().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public BinaryTreeNode<T> findNode(T value) {
        var node = this.getRoot();
        int comparison;

        do {
            comparison = node.getData().compareTo(value);

            if (comparison < 0) {
                node = node.getLeft();
            }
            else if (comparison > 0) {
                node = node.getRight();
            }

        } while (node != null && comparison != 0);

        return node;
    }
}
