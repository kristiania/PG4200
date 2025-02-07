package data.structures.list;

import java.util.Iterator;
import java.util.Optional;

public class SinglyLinkedList<E>
        implements ListImplementation<E>
{
    //# Inner classes
    public class Node<T>
    {
        //# Node::Fields
        protected T data;
        protected Node<T> next = null;


        //# Node::Constructors
        private Node(T element) {
            this.data = element;
        }


        //# Node::Methods
        public T getData() {
            return this.data;
        }

        public Node<T> getNextNode() {
            return this.next;
        }

        public boolean isFirst() {
            return SinglyLinkedList.this.head == this;
        }

        public boolean isLast() {
            return this.next == null;
        }

        public SinglyLinkedList<E> getLinkedList() {
            return SinglyLinkedList.this;
        }
    }


    //# Fields
    private Node<E> head = null;


    //# Constructors
    public SinglyLinkedList() {}

    public SinglyLinkedList(E element) {
        this.head = this.createNode(element);
    }


    //# Methods
    public Node<E> createNode(E element) {
        return this.new Node<>(element);
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    public int length() {
        if (this.isEmpty()) {
            return 0;
        }

        var node = this.head;
        var count = 1;

        while (node.next != null) {
            count ++;
            node = node.next;
        }

        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node<E> getFirstNode() {
        return this.head;
    }

    public Node<E> getLastNode() {
        var node = this.head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    @Override
    public void add(E element) {
        this.add(this.createNode(element));
    }

    public void add(Node<E> node) {
        this.insertLast(node);
    }

    public void insertFirst(E element) {
        this.insertFirst(this.createNode(element));
    }

    public void insertFirst(Node<E> node) {
        if (this.created(node)) {
            if (!this.isEmpty()) {
                node.next = this.head;
            }

            this.head = node;
        }
    }

    public void insertLast(E element) {
        this.insertLast(this.createNode(element));
    }

    public void insertLast(Node<E> node) {
        if (this.created(node)) {
            if (this.isEmpty()) {
                this.head = node;
            } else {
                this.getLastNode().next = node;
            }
        }
    }

    public void insertBefore(Node<E> target, Node<E> node) {
        if (this.created(target) && this.created(node)) {
            if (target.isFirst()) {
                this.insertFirst(node);
            }
            else {
                var nodeBeforeTarget = this.getNodeBefore(target);

                nodeBeforeTarget.ifPresent(previousNode -> {
                    previousNode.next = node;
                    node.next = target;
                });
            }
        }
    }

    public void insertAfter(Node<E> target, Node<E> node) {
        if (this.created(target) && this.created(node)) {
            if (!target.isLast()) {
                node.next = target.next;
            }

            target.next = node;
        }
    }




    public void remove(Node<E> node) {
        if (this.created(node)) {
            var nodeBefore = this.getNodeBefore(node);

            nodeBefore.ifPresent(previousNode -> previousNode.next = node.next);
        }
    }

    public void removeFirst() {
        if (!this.isEmpty()) {
            if (this.head.next != null) {
                this.head = this.head.next;
            }
        }
    }


    //# Search Operations
    public boolean search(E element) {
        if (this.isEmpty()) {
            return false;
        }

        var node = this.head;

        while (node != null) {
            if (node.data == element) {
                return true;
            }

            node = node.next;
        }

        return false;
    }

    public boolean search(Node<E> node) {
        if (node == null || node.getLinkedList() != this) {
            return false;
        }

        var cursor = this.head;

        while (cursor != null) {
            if (cursor == node) {
                return true;
            }

            cursor = node.next;
        }

        return false;
    }


    //# Traversal Operations
    public void traverse() {
        this.traverse(" ");
    }

    public void traverse(String delimiter) {
        var cursor = this.head;

        while (cursor != null) {
            System.out.printf("%s%s", cursor.data, cursor.isLast() ? "" : delimiter);

            cursor = cursor.next;
        }

        System.out.println();
    }


    //# Overrides
    @Override
    public Iterator<E> iterator() {
        var head = this.getFirstNode();

        return new Iterator<E>() {
            private Node<E> cursor = head;

            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            @Override
            public E next() {
                var output = this.cursor.data;
                this.cursor = this.cursor.next;

                return output;
            }
        };
    }


    //# Helper-methods
    private boolean created(Node<E> node) {
        if (node == null) {
            return false;
        }

        return node.getLinkedList() == this;
    }

    private Optional<Node<E>> getNodeBefore(Node<E> node) {
        if (this.created(node)) {
            var cursor = this.head;

            while (cursor != null) {
                if (cursor.next != null && cursor.next == node) {
                    return Optional.of(cursor);
                }

                cursor = cursor.next;
            }
        }

        return Optional.empty();
    }

    private Optional<Node<E>> getNodeAfter(Node<E> node) {
        if (this.created(node)) {
            return Optional.of(node.next);
        }

        return Optional.empty();
    }
}
