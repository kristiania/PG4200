package data.structures.tree;

import data.structures.list.ArrayList;
import data.structures.queue.SinglyLinkedListLinearQueue;
import data.structures.stack.SinglyLinkedListStack;

import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.NotNull;


public class ArrayListNodeTree<E>
        implements TreeImplementation<E, ArrayListNodeTree<E>>
{
    //# Fields
    private final E value;
    transient private final ArrayList<ArrayListNodeTree<E>> children = new ArrayList<>();


    //# Constructors
    public ArrayListNodeTree(E value) {
        this.value = value;
    }

    public ArrayListNodeTree(E value, @NotNull List<E> children) {
        this(value);

        for (var element : children) {
            this.children.add(new ArrayListNodeTree<>(element));
        }
    }


    //# Getter-methods
    public E getValue() {
        return this.value;
    }

    public ArrayList<ArrayListNodeTree<E>> getChildren() {
        return this.children;
    }


    //# Insertion
    public ArrayListNodeTree<E> insert(E element) {
        var child = new ArrayListNodeTree<>(element);

        this.children.add(child);

        return child;
    }


    //# Traversal
    @Override
    public @NotNull Iterator<E> iterator() {
        return this.depthFirst();
    }

    public Iterator<E> depthFirst() {
        var stack = new SinglyLinkedListStack<ArrayListNodeTree<E>>();

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
        var queue = new SinglyLinkedListLinearQueue<ArrayListNodeTree<E>>();

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
