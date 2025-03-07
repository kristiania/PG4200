import data.structures.queue.SinglyLinkedListLinearQueue;
import data.structures.tree.ArrayListNodeTree;

void main() {
    /*
        /
        └── Root
            ├── Level 1A
            │   ├── Level 1A 2A
            │   │   ├── Level 1A 2A 3A
            │   │   └── Level 1A 2A 3B
            │   └── Level 1A 2B
            │       ├── Level 1A 2B 3A
            │       └── Level 1A 2B 3B
            └── Level 1B
                ├── Level 1B 2A
                │   ├── Level 1B 2A 3A
                │   └── Level 1B 2A 3B
                └── Level 1B 2B
                    ├── Level 1B 2B 3A
                    └── Level 1B 2B 3B
     */
    var tree = new ArrayListNodeTree<>("Root");

    tree.insert("Level 1A");
    tree.insert("Level 1B");

    tree.getChildren().get(0).insert("Level 1A 2A");
    tree.getChildren().get(0).getChildren().get(0).insert("Level 1A 2A 3A");
    tree.getChildren().get(0).getChildren().get(0).insert("Level 1A 2A 3B");

    tree.getChildren().get(0).insert("Level 1A 2B");
    tree.getChildren().get(0).getChildren().get(1).insert("Level 1A 2B 3A");
    tree.getChildren().get(0).getChildren().get(1).insert("Level 1A 2B 3B");

    tree.getChildren().get(1).insert("Level 1B 2A");
    tree.getChildren().get(1).getChildren().get(0).insert("Level 1B 2A 3A");
    tree.getChildren().get(1).getChildren().get(0).insert("Level 1B 2A 3B");

    tree.getChildren().get(1).insert("Level 1B 2B");
    tree.getChildren().get(1).getChildren().get(1).insert("Level 1B 2B 3A");
    tree.getChildren().get(1).getChildren().get(1).insert("Level 1B 2B 3B");


    //# Breadth-First Traversal implementation
    // 1) Start with an empty queue
    var queue = new SinglyLinkedListLinearQueue<ArrayListNodeTree<String>>();

    // 2) Enqueue root node (tree itself) to the queue
    queue.enqueue(tree);

    System.out.println("Tree (Breadth First):");

    // Current node we are looking at during iterations
    ArrayListNodeTree<String> node;

    // 3) Go through each node in the queue as long as it is not empty
    while (!queue.isEmpty()) {
        node = queue.dequeue();

        System.out.printf("- %s%n", node.getValue());

        // 4) Add the children of the popped element to the queue
        for (var childNode : node.getChildren()) {
            queue.enqueue(childNode);
        }
    }
}
