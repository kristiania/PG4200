package data.structures.queue;

public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException() {
        super("Underflow occurred due to operation performed on an empty queue");
    }
}
