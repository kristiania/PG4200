package data.structures.array;

import java.util.Arrays;


public class StaticArray<E>
{
    //# Fields
    private final E[] data;


    //# Constructors
    public StaticArray(int size) {
        this.data = Arrays.copyOf(StaticArray.getGenericArray(), size);
    }

    //# Methods
    public int length() {
        return this.data.length;
    }

    public E get(int index) {
        if (!this.indexInBounds(index)) {
            throw new IndexOutOfBoundsException(index);
        }

        return this.data[index];
    }

    public E getFirst() {
        return this.data[0];
    }

    public E getLast() {
        return this.data[this.lastIndex()];
    }

    public void insert(int index, E element) {
        if (this.indexInBounds(index)) {
            this.data[index] = element;
        }
    }

    public void insertFirst(E element) {
        this.insert(0, element);
    }

    public void insertLast(E element) {
        this.insert(this.lastIndex(), element);
    }

    public void delete(int index) {
        if (this.indexInBounds(index)) {
            this.data[index] = null;
        }
    }


    //# Helper-methods
    public boolean indexInBounds(int index) {
        return index >= 0 && index < this.length();
    }

    public int lastIndex() {
        return this.length() - 1;
    }

    // Allows us to construct an (empty) static array based on the generic type provided at runtime
    @SafeVarargs
    public static <T> T[] getGenericArray(T... elements) {
        return elements;
    }
}
