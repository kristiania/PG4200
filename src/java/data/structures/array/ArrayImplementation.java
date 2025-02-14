package data.structures.array;

import java.util.function.Consumer;


public interface ArrayImplementation<E>
{
    E get(int index);

    void set(int index, E element);

    int size();

    int indexOf(E element);
    int lastIndexOf(E element);
    default boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    void forEach(Consumer<E> function);
}
