import data.structures.list.SinglyLinkedList;


void main() {
    var list = new SinglyLinkedList<String>();

    list.add("One");
    list.add("Two");
    list.add("Three");
    list.add("Four");
    list.add("Five");

    // What we are looking for
    String x = "Three";
    boolean found = false;

    //# Traverse through linked list to be able to search for x

    // 1) Start with the first node in the linked list
    var node = list.getFirstNode();

    int count = 1;
    while (node != null) {
        if (node.getData().equals(x)) {
            found = true;
            break;
        }
        else {
            node = node.getNextNode();
            count ++;
        }
    }

    if (found) {
        System.out.printf("Found x in node number %d%n", count);
    }
    else {
        System.out.println("Could not find x in the linked list");
    }

}
