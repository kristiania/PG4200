package data.structures.tree;

import data.structures.list.ArrayList;
import data.structures.queue.SinglyLinkedListLinearQueue;
import data.structures.stack.SinglyLinkedListStack;
import data.structures.tree.node.TreeNode;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;


public class ArrayListTree<E>
        extends TreeNode<E>
        implements TreeImplementation<E, ArrayListTree<E>>
{
    //# Fields
    private final E value;
    transient private final ArrayList<ArrayListTree<E>> children = new ArrayList<>();


    //# Constructors
    public ArrayListTree(E value) {
        this.value = value;
    }

    public ArrayListTree(E value, @NotNull List<E> children) {
        this(value);

        for (var element : children) {
            this.children.add(new ArrayListTree<>(element));
        }
    }


    //# Getter-methods
    public E getValue() {
        return this.value;
    }


    //# Insertion
    public void add(E element) {
        this.children.add(new ArrayListTree<>(element));
    }


    //# Traversal
    @Override
    public @NotNull Iterator<E> iterator() {
        return this.depthFirst();
    }

    public Iterator<E> depthFirst() {
        var stack = new SinglyLinkedListStack<ArrayListTree<E>>();

        stack.push(this);

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public E next() {
                var tree = stack.pop();

                tree.children.forEach(stack::push);

                return tree.getValue();
            }
        };
    }


    public Iterator<E> breadthFirst() {
        var queue = new SinglyLinkedListLinearQueue<ArrayListTree<E>>();

        queue.enqueue(this);

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                var tree = queue.dequeue();

                tree.children.forEach(queue::enqueue);

                return tree.getValue();
            }
        };
    }


    //# Search
    public boolean search(E element) {
        for (var node : this) {
            if (node.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(Iterator<E> iterator, E element) {
        while (iterator.hasNext()) {
            var node = iterator.next();

            if (node.equals(element)) {
                return true;
            }
        }

        return false;
    }
}
