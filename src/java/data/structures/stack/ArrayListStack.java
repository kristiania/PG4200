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

        var output = this.data.getFirst();

        this.data.removeFirst();

        return this.data.getFirst();
    }

    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.data.getFirst();
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
