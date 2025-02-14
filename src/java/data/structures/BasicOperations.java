package data.structures;


import java.util.function.Predicate;

public interface BasicOperations<T>
{
    //# Searching
    T search(Predicate<T> condition);
    boolean exists(T object);

    //# Sorting
    void sort();

    //# Insertion
    boolean add(T object);


}
