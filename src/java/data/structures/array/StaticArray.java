package data.structures.array;

import data.structures.DataStructure;
import data.structures.Wrapper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;


public class StaticArray<E>
        implements ArrayImplementation<E>
{
    //# Fields
    private final E[] data;


    //# Constructors
    public StaticArray(int size) {
        this.data = Arrays.copyOf(StaticArray.getGenericArray(), size);
    }


    //# Helper-methods
    protected void shift(int index) {
        if (this.indexInBounds(index)) {
            for (int i = this.data.length - 1; i > index; i --) {
                this.data[i] = this.get(i - 1);
            }
        }
    }


    //# Methods
    public int length() {
        return this.data.length;
    }

    @Override
    public int size() {
        return this.length();
    }

    public E get(int index) {
        if (!this.indexInBounds(index)) {
            throw new IndexOutOfBoundsException(index);
        }

        return this.data[index];
    }

    public Iterator<E> iterator() {
        final var index = new Wrapper<>(0);
        final var size = this.size();
        final Function<Integer, E> getter = this::get;

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index.get() < size;
            }

            @Override
            public E next() {
                var buffer = getter.apply(index.get());

                index.set(index.get() + 1);

                return buffer;
            }
        };
    }


    public E getFirst() {
        return this.data[0];
    }

    public E getLast() {
        return this.data[this.lastIndex()];
    }

    public void insert(int index, E element) {
        if (this.indexInBounds(index)) {
            this.shift(index);
            this.set(index, element);
        }
    }

    @Override
    public E replace(int index, E element) {
        return null;
    }


    public void insertFirst(E element) {
        this.insert(0, element);
    }

    public void insertLast(E element) {
        this.set(this.lastIndex(), element);
    }

    public void set(int index, E element) {
        if (this.indexInBounds(index)) {
            this.data[index] = element;
        }
    }

    public void setLast(E element) {
        this.set(this.lastIndex(), element);
    }

    public E remove(int index) {
        if (this.indexInBounds(index)) {
            var buffer = this.get(index);

            this.delete(index);

            return buffer;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public void delete(int index) {
        if (this.indexInBounds(index)) {
            this.data[index] = null;
        }
    }

    public void swap(int i, int j) {
        if (i == j || !this.indexInBounds(i) || !this.indexInBounds(j)) {
            return;
        }

        var buffer = this.get(i);

        this.set(i, this.get(j));
        this.set(j, buffer);
    }


    //# Helper-methods
    public boolean indexInBounds(int index) {
        return index >= 0 && index < this.length();
    }

    public int lastIndex() {
        return this.length() - 1;
    }

    @Override
    public int indexOf(E element) {
        var index = 0;

        for (var iterator = this.iterator(); iterator.hasNext(); index ++) {
            if (iterator.next().equals(element)) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        var output = -1;
        var index = 0;

        for (var iterator = this.iterator(); iterator.hasNext(); index ++) {
            if (iterator.next().equals(element)) {
                output = index;
            }
        }

        return output;
    }

    // Allows us to construct an (empty) static array based on the generic type provided at runtime
    @SafeVarargs
    public static <T> T[] getGenericArray(T... elements) {
        return elements;
    }
}
