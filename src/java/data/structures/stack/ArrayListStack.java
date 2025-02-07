package data.structures.stack;

import data.structures.list.ArrayList;
import java.util.EmptyStackException;


public class ArrayListStack<E>
        implements StackImplementation<E>
{
    //# Fields
    private final ArrayList<E> data = new ArrayList<>();


    //# Methods
    public void push(E element) {
        this.data.add(element);
    }

    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        var output = this.data.getLast();

        this.data.removeLast();

        return output;
    }

    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.data.getLast();
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
