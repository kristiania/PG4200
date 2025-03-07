package data.structures.queue;

import data.structures.array.StaticArray;
import data.structures.queue.implementation.QueueImplementation;


public class StaticArrayPriorityQueue<E extends Comparable<E>>
        implements QueueImplementation<E>
{
    protected class Node
            implements Comparable<Node>
    {
        private final E element;
        private final int priority;

        public Node(E element, int priority) {
            this.element = element;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node object) {
            if (this.priority == object.priority) {
                if (this.element.equals(object.element)) {
                    return 0;
                }
                else {
                    return this.element.compareTo(object.element);
                }
            }


            return 0;
        }

        /*
        @Override
        public boolean equals(Object object) {
            try {
                if (object instanceof Node) {
                    Node node = (Node) object;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
        */

        public boolean equals(Node node) {
            return (
                this.priority == node.priority
             && this.element.equals(node.element)
            );
        }
    }

    //# Fields
    private final StaticArray<Node> data;
    private int cursor = -1;


    //# Constructor
    public StaticArrayPriorityQueue(int size) {
        this.data = new StaticArray<>(size);
    }


    //# Helper-methods
    protected Node createNode(E element, int priority) {
        return this.new Node(element, priority);
    }

    protected Node get(int index) {
        if (this.data.indexInBounds(index)) {
            return this.data.get(index);
        }

        return null;
    }

    protected int getHighestPriorityElementIndex() {
        int priority = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0, n = this.length(); i < n; i ++) {
            // TODO
        }

        return index;
    }

    //# Queue-methods
    @Override
    public void enqueue(E element) {
        this.enqueue(element, 0);
    }

    public void enqueue(E element, int priority) {
        this.data.insertLast(this.createNode(element, priority));
    }

    @Override
    public E dequeue() {
        var buffer = this.data.getFirst();
        var priority = Integer.MIN_VALUE;

        return null; // TODO
    }

    public E peek() {
        return this.data.getFirst().element;
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
