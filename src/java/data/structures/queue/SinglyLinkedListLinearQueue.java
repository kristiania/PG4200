package data.structures.queue;

import data.structures.list.SinglyLinkedList;
import data.structures.queue.exceptions.UnderflowQueueException;
import data.structures.queue.implementation.QueueImplementation;


public class SinglyLinkedListLinearQueue<E>
        implements QueueImplementation<E>
{
    //# Fields
    private final SinglyLinkedList<E> data = new SinglyLinkedList<>();


    //# Methods
    public void enqueue(E element) {
        this.data.add(element);
    }

    public E dequeue() {
        var node = this.data.getFirstNode();

        if (node != null) {
            this.data.removeFirst();

            return node.getData();
        }

        throw new UnderflowQueueException();
    }


    public E peek() {
        var node = this.data.getFirstNode();

        if (node != null) {
            return node.getData();
        }

        throw new UnderflowQueueException();
    }

    public int length() {
        return this.data.length();
    }

    public boolean isEmpty() {
        return this.data.getFirstNode() == null;
    }
}
