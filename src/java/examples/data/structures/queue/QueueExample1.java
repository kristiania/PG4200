import data.structures.queue.SinglyLinkedListLinearQueue;


record Person(String name) {}


void main() {
    var queue = new SinglyLinkedListLinearQueue<Person>();

    queue.enqueue(new Person("Alice"));
    queue.enqueue(new Person("Bob"));
    queue.enqueue(new Person("Charlie"));

    System.out.printf("Next person in the queue: %s%n", queue.peek().name());

    var nextPerson = queue.dequeue();

    if (nextPerson.name().equals("Alice")) {
        System.out.println("Alice entered the queue first and was removed from the queue first!");
    }

    if (queue.peek().name().equals("Bob")) {
        System.out.println("Bob is next in the queue after Alice was removed from the queue");
    }
}
