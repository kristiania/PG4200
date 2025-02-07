package data.structures.list;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
    This is a "wrapper" around java.util.ArrayList!

    Strictly unnecessary - only used to follow the same structure used within this repository!
*/
public class ArrayList<E>
        implements ListImplementation<E>
{
    //# Fields
    protected final java.util.ArrayList<E> data;


    //# Constructors
    public ArrayList() {
        this.data = new java.util.ArrayList<E>();
    }

    public ArrayList(int initialCapacity) {
        this.data = new java.util.ArrayList<E>(initialCapacity);
    }

    public ArrayList(Collection<? extends E> collection) {
        this.data = new java.util.ArrayList<E>(collection);
    }


    //# Methods
    public E get(int index) {
        return this.data.get(index);
    }

    public int indexOf(E element) {
        return this.data.indexOf(element);
    }

    public int lastIndexOf(E element) {
        return this.data.lastIndexOf(element);
    }

    public void add(E element) {
        this.data.add(element);
    }

    public void removeFirst() {
        this.data.removeFirst();
    }

    public void removeLast() {
        this.data.removeLast();
    }

    public void add(List<E> elements) {
        this.data.addAll(elements);
    }

    @Override
    public @NotNull Iterator<E> iterator() {
        return this.data.listIterator(0);
    }
}
