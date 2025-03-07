package data.structures.queue;

import data.structures.array.StaticArray;
import data.structures.queue.implementation.QueueImplementation;

public class StaticArrayQueue<E>
        implements QueueImplementation<E>
{
    //# Fields
    private final StaticArray<E> data;


    //# Constructor
    public StaticArrayQueue(int size) {
        this.data = new StaticArray<>(size);
    }


    //# Helper-methods



    //# Queue-methods
    @Override
    public void enqueue(E element) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }
}
