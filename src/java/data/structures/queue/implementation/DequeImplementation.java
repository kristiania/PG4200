package data.structures.queue.implementation;


import java.util.Queue;

public interface DequeImplementation<E>
        extends QueueImplementation<E>
{

    void enqueueFirst(E element);
    void peekLast();

    Queue<E> toQueue();
}
