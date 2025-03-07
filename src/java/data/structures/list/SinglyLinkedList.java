package data.structures.list;

import java.util.Iterator;
import java.util.Optional;


/**
 * Implementation of a Singly Linked List
 *
 *  The linked list itself only holds one reference to the first node as `head`,
 *  and this reference is used for initial point of traversal.
 *
 * @param <T> Which type of data stored in the underlying data storage (nodes)
 */
public class SinglyLinkedList<T>
        implements ListImplementation<T>
{
    //# Inner classes
    /**
     *  As Inner Class instances holds a reference to the Outer Class,
     *  this is used to link nodes to the linked list that created the nodes
     */
    public class Node
    {
        //# Node::Fields
        /** Data contained within the bode */
        protected T data;
        /** A reference to the next node this points to, null if no next node */
        protected Node next = null;


        //# Node::Constructors

        /**
         * Constructs a SinglyLinkedList::Node instance,
         * private so only the linked list itself can invoke the constructor
         *
         * @param element Data value to be stored within the node
         */
        private Node(T element) {
            this.data = element;
        }


        //# Node::Methods

        /**
         * Returns the data value contained within this node
         *
         * @return Data value
         */
        public T getData() {
            return this.data;
        }

        /**
         * Return the next node that this node references, null if none available
         *
         * @return Node | null
         */
        public Node getNextNode() {
            return this.next;
        }

        /**
         * Returns whether this node is the first node in the linked list or not
         *
         * @return boolean
         */
        public boolean isFirst() {
            return SinglyLinkedList.this.head == this;
        }

        /**
         * Returns whether this node is the last node in the linked list or not
         *
         * @return boolean
         */
        public boolean isLast() {
            return this.next == null;
        }

        /**
         * Sets this node's next reference to the provided node
         *
         * @param node Node | null
         */
        private void setNext(Node node) {
            this.next = node;
        }

        /**
         * Returns a reference to the linked list this node stems from
         *
         * @return SinglyLinkedList
         */
        public SinglyLinkedList<T> getLinkedList() {
            return SinglyLinkedList.this;
        }
    }


    //# Fields
    private Node head = null;


    //# Constructors
    public SinglyLinkedList() {}

    public SinglyLinkedList(T element) {
        this.head = this.createNode(element);
    }


    //# Methods
    public Node createNode(T element) {
        return this.new Node(element);
    }

    @Override
    public T get(int index) {
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

    public Node getFirstNode() {
        return this.head;
    }

    public Node getLastNode() {
        var node = this.head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    public int indexOf(T element) {
        throw new UnsupportedOperationException();
    }


    public int lastIndexOf(T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T element) {
        this.add(this.createNode(element));
    }

    public void add(Node node) {
        this.insertLast(node);
    }

    public void insertFirst(T element) {
        this.insertFirst(this.createNode(element));
    }

    public void insertFirst(Node node) {
        if (this.created(node)) {
            if (!this.isEmpty()) {
                node.next = this.head;
            }

            this.head = node;
        }
    }

    public void insertLast(T element) {
        this.insertLast(this.createNode(element));
    }

    public void insertLast(Node node) {
        if (this.created(node)) {
            if (this.isEmpty()) {
                this.head = node;
            } else {
                this.getLastNode().next = node;
            }
        }
    }

    public void insertBefore(Node target, Node node) {
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

    public void insertAfter(Node target, Node node) {
        if (this.created(target) && this.created(node)) {
            if (!target.isLast()) {
                node.next = target.next;
            }

            target.next = node;
        }
    }




    public void remove(Node node) {
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
            else {
                this.head = null;
            }
        }
    }


    //# Search Operations
    public boolean search(T element) {
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

    public boolean search(Node node) {
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
    public Iterator<T> iterator() {
        var head = this.getFirstNode();

        return new Iterator<>() {
            private Node cursor = head;

            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            @Override
            public T next() {
                var output = this.cursor.data;
                this.cursor = this.cursor.next;

                return output;
            }
        };
    }


    //# Helper-methods
    private boolean created(Node node) {
        if (node == null) {
            return false;
        }

        return node.getLinkedList() == this;
    }

    private Optional<Node> getNodeBefore(Node node) {
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

    private Optional<Node> getNodeAfter(Node node) {
        if (this.created(node)) {
            return Optional.of(node.next);
        }

        return Optional.empty();
    }
}
