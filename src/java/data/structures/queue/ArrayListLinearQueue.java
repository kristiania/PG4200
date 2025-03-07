package data.structures.queue;

import data.structures.list.ArrayList;
import data.structures.queue.implementation.QueueImplementation;

public class ArrayListLinearQueue<E>
        implements QueueImplementation<E>
{
    //# Fields
    private final ArrayList<E> data = new ArrayList<>();


    //# Constructors
    public ArrayListLinearQueue() {}


    //# Queue-methods
    @Override
    public void enqueue(E element) {
        this.data.add(element);
    }

    @Override
    public E dequeue() {
        return this.data.removeFirst(); // FIFO
    }

    @Override
    public E peek() {
        return this.data.getFirst();
    }

    @Override
    public int length() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }
}
