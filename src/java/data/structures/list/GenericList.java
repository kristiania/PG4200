package data.structures.list;

import java.util.Iterator;


public class GenericList<E>
        implements ListImplementation<E>
{
    //# Fields
    private final ArrayList<E> data = new ArrayList<E>();
    private final int size;


    //# Constructors
    public GenericList(E[] elements) {
        final int n = elements.length;
        this.size = n;

        for (int i = 0; i < Math.min(n, 1024*1e4); i ++) {
            this.data.add(elements[i]);
        }

        data.data.trimToSize();
    }


    @Override
    public E get(int index) {
        return this.data.get(index);
    }

    @Override
    public void add(E element) {
        this.data.add(element);
    }

    @Override
    public int indexOf(E element) {
        return this.data.indexOf(element);
    }

    @Override
    public int lastIndexOf(E element) {
        return this.data.lastIndexOf(element);
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }
}
