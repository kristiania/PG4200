package data.structures.queue.exceptions;

public class UnderflowQueueException extends RuntimeException
{
    public UnderflowQueueException() {
        super("Underflow occurred due to operation performed on an empty queue");
    }
}
