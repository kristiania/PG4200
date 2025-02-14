import data.structures.Wrapper;


void main() {
    var list = new LinkedList<Integer>();

    var node1 = list.insert(1);
    var node2 = list.insert(2);
    var node3 = list.insert(8);

    list.forEachValue(System.out::println);
}


static class LinkedList<T>
{
    //# LinkedList<T>::Node Inner-class
    public class Node {
        private final T data;
        private Node next = null;

        private Node(T value) {
            this.data = value;
        }
    }

    //# Fields
    private Node head = null;
    private int size = 0;


    //# Methods
    public Node createNode(T value) {
        return this.new Node(value);
    }

    public boolean isEmpty() {
        return this.head == null;
    }


    //# Insertion
    public Node insert(T value) {
        return this.insert(this.createNode(value));
    }

    public Node insert(Node node) {
        if (this.isEmpty()) {
            this.head = node;
            this.size ++;

            return node;
        }
        else {
            var target = this.head;

            while (target.next != null) {
                target = target.next;
            }

            target.next = node;
            this.size ++;

            return node;
        }
    }


    //# Traversal
    public Iterator<T> iterator() {
        var iterator = nodeIterator();

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next().data;
            }
        };
    }

    protected Iterator<Node> nodeIterator() {
        final var node = new Wrapper<>(this.head);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return node.get() != null;
            }

            @Override
            public Node next() {
                var output = node.get();

                node.set(node.get().next);

                return output;
            }
        };
    }

    public void forEachValue(Consumer<T> consumer) {
        var iterator = this.iterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public void forEachNode(Consumer<Node> consumer) {
        var iterator = this.nodeIterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }


    //# Search
    public Node find(T value) {
        return null;
    }
}


