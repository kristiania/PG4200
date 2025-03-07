package data.structures;

import java.util.Comparator;


public interface Sortable<T, E>
{

    T sortCopy(Comparator<E> comparator);
}
