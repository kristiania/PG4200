package data.structures.stack;

import data.structures.list.SinglyLinkedList;
import java.util.EmptyStackException;


public class SinglyLinkedListStack<E>
        implements StackImplementation<E>
{
    //# Fields
    private final SinglyLinkedList<E> data = new SinglyLinkedList<>();


    //# Methods
    public void push(E element) {
        this.data.insertFirst(element);
    }

    public E pop() {
        var node = this.data.getFirstNode();

        if (node != null) {
            this.data.removeFirst();

            return node.getData();
        }

        throw new EmptyStackException();
    }

    public E peek() {
        var node = this.data.getFirstNode();

        if (node != null) {
            return node.getData();
        }

        throw new EmptyStackException();
    }

    public int size() {
        return this.data.length();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
