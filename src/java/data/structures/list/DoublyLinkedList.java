package data.structures.list;

import data.structures.queue.implementation.QueueImplementation;
import data.structures.queue.SinglyLinkedListLinearQueue;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Predicate;


public class DoublyLinkedList<E>
{
    //# Fields
    private Node head = null;
    private Node tail = null;


    //## DoublyLinkedList::Node
    public class Node
            implements Iterable<Node>
    {
        private final E data;
        private Node previous = null;
        private Node next = null;

        private Node(E element) {
            this.data = element;
        }

        protected E getData() {
            return this.data;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public Iterator<Node> iterator() {
            return this.iteratorNodesNext();
        }

        protected Iterator<Node> iteratorNodesNext() {
            return this.iteratorPredicate(
                    (node) -> node.next != null,
                    (node, queue) -> queue.enqueue(node.next)
            );
        }

        protected Iterator<Node> iteratorNodesPrevious() {
            return this.iteratorPredicate(
                    (node) -> node.previous != null,
                    (node, queue) -> queue.enqueue(node.previous)
            );
        }

        private Iterator<Node> iteratorPredicate(
                Predicate<Node> predicate,
                BiConsumer<Node, QueueImplementation<Node>> consumer
        ) {
            var queue = new SinglyLinkedListLinearQueue<Node>();

            queue.enqueue(this);

            return new Iterator<Node>() {
                @Override
                public boolean hasNext() {
                    return queue.peek() != null;
                }

                @Override
                public Node next() {
                    var node = queue.dequeue();

                    if (predicate.test(node)) {
                        consumer.accept(node, queue);
                    }

                    return node;
                }
            };
        }


        //# Introspection
        public DoublyLinkedList<E> getLinkedList() {
            return DoublyLinkedList.this;
        }

        public boolean isInnerContext() {
            return this.getLinkedList() == DoublyLinkedList.this;
        }

        public boolean isFirstNode() {
            return this.getLinkedList().head == this;
        }

        public boolean isLastNode() {
            return this.getLinkedList().tail == this;
        }
    }


    //# Helper-method for creating new nodes with raw elements
    public Node createNode(E element) {
        return this.new Node(element);
    }


    //# Constructors
    public DoublyLinkedList() {}
    public DoublyLinkedList(E element) {
        this.head = this.createNode(element);
        this.tail = this.head;
    }


    //# Getter-methods
    public Node getFirstNode() {
        return this.head;
    }

    public Node getLastNode() {
        return this.tail;
    }


    //# Insertion
    public void insert(E element) {
        this.insert(this.createNode(element));
    }

    public void insert(Node node) {
        this.insertLast(node);
    }

    public void insertFirst(E element) {
        this.insertFirst(this.createNode(element));
    }

    public void insertFirst(Node node) {
        this.head.previous = node;
        this.head = node;
    }

    public void insertLast(Node node) {
        this.tail.next = node;
        this.tail = node;
    }


    //# Iterator
    public Iterator<E> iterator() {
        final var node = new ArrayList<Node>(1);

        node.add(0, this.head);

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return node.get(0) != null;
            }

            @Override
            public E next() {
                var output = node.removeLast();

                node.add(0, output.next);

                return output.getData();
            }
        };
    }

    //# Deletion
    public void delete(Node node) {
        if (node.isInnerContext()) {
            if (node.previous != null) {
                node.previous.next = node.next;
            }

            if (node.next != null) {
                node.next.previous = node.previous;
            }
        }
        /*
        else {
            // TODO: pass along element reference to original list as creator of node element
        }
        */
    }


    //# Sorting
    protected void swap(Node A, Node B) {
        Node temp = null;

        if (A.isInnerContext() && B.isInnerContext()) {
            temp = B;

            if (A.previous != null) {
                A.previous.next = temp;
                B.previous = A.previous;
            }

            if (A.next != null) {
                A.next.previous = temp;
                B.next = A.next;
            }

            temp = A;

            if (B.previous != null) {
                B.previous.next = temp;
                A.next = B.previous;
            }

            if (B.next != null) {
                B.next.previous = temp;
                A.previous = B.next;
            }
        }
    }


    //# Searching
    public int indexOf(E element) {
        throw new UnsupportedOperationException();
    }


    public int lastIndexOf(E element) {
        throw new UnsupportedOperationException();
    }


    public boolean isEmpty() {
        return this.head == null;
    }


    //# Helper-methods
    public E unwrap(Node node) {
        return node.isInnerContext() ? node.getData() : null;
    }
}
