package data.structures.stack;

import data.structures.array.StaticArray;
import java.util.EmptyStackException;


public class StaticArrayStack<E>
        implements StackImplementation<E>
{
    //# Fields
    private final StaticArray<E> data;
    private int top = -1;


    //# Constructors
    public StaticArrayStack(int size) {
        this.data = new StaticArray<>(size);
    }


    //# Methods
    public void push(E element) {
        if (!this.canPush()) {
            throw new StackOverflowError();
        }

        this.top ++;
        this.data.insert(this.top, element);
    }

    public E pop() {
        if (this.canPop()) {
            return this.data.get(this.top --);
        }

        throw new EmptyStackException();
    }

    public E peek() {
        if (!this.canPop()) {
            throw new EmptyStackException();
        }

        return this.data.get(this.top);
    }

    public int size() {
        return this.top + 1;
    }

    public int length() {
        return this.data.length();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }


    //# Helper-methods
    private boolean canPop() {
        return this.top > -1;
    }

    private boolean canPush() {
        return this.top < this.data.lastIndex();
    }
}
