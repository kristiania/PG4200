package data.structures.queue;

import data.structures.list.SinglyLinkedList;


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

        throw new EmptyQueueException();
    }


    public E peek() {
        var node = this.data.getFirstNode();

        if (node != null) {
            return node.getData();
        }

        throw new EmptyQueueException();
    }

    public int length() {
        return this.data.length();
    }

    public boolean isEmpty() {
        return this.data.getFirstNode() == null;
    }
}
