package data.structures.queue;

import data.structures.list.DoublyLinkedList;

public class DoublyLinkedListDeque<E>
{
    //# Fields
    private final DoublyLinkedList<E> data = new DoublyLinkedList<>();


    //# Constructors
    public DoublyLinkedListDeque() {}


    //# Getter-methods


    public E peekFirst() {
        return this.data.unwrap(this.data.getFirstNode());
    }

    public E peekLast() {
        return this.data.unwrap(this.data.getLastNode());
    }


    //# Insertion
    public void enqueue(E element) {
        this.data.insertLast(this.data.createNode(element));
    }
}
