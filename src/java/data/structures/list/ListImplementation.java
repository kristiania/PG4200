package data.structures.list;

import java.lang.Iterable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;


public interface ListImplementation<E>
        extends Iterable<E>
{
    //# Read operations
    E get(int index);


    //# Insertion operations
    void add(E e);

    default void add(int index, E element) {
        throw new UnsupportedOperationException();
    }


    //# Update operations
    default E set(int index, E element) {
        throw new UnsupportedOperationException();
    }


    //# Delete operations
    default E remove(int index) {
        throw new UnsupportedOperationException();
    }


    //# Sorting operations
    default void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }


    //# Search operations
    int indexOf(E element);
    int lastIndexOf(E element);
    Iterator<E> iterator();


    //# Traversal operations
    default void forEach(Consumer<? super E> consumer) {
        for (var element : this) {
            consumer.accept(element);
        }
    }
}
