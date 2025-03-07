package data.structures.queue.implementation;


/**
 *  FIFO; First-In-First-Out:
 *  <br>
 *  Provides a simple interface for queue implementations;
 *  <br><br>
 *          void enqueue(E element):<br>
 *              Adds element to the first available position in the queue
 * <br><br>
 *          E dequeue():<br>
 *              Removes and returns the first element in the queue
 * <br><br>
 *          E peek():<br>
 *              Return the first element in the queue (with no modifications made)
 * <br><br>
 *          boolean isEmpty():<br>
 *              Does the queue contain any elements?
 * <br><br>
 *          int length():<br>
 *              Returns the current length of the queue,
 *              int size() might be available to provide max length of the queue
 */
public interface QueueImplementation<E>
{
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int length();
}
