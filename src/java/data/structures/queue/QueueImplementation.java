package data.structures.queue;


public interface QueueImplementation<E>
{
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int length();
}
