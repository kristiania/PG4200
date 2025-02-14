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


    Iterator<String> depthFirstIterator = tree.depthFirst();

    while (depthFirstIterator.hasNext()) {
        var node = depthFirstIterator.next();

        System.out.println(node);
    }


    /*
    //# Depth First Traversal implementation
    // 1) Start with an empty stack
    var stack = new ArrayListStack<ArrayListTree<String>>();

    // 2) Push root node (tree itself) to the stack
    stack.push(tree);

    System.out.println("Tree (Depth First):");

    // Current node we are looking at during iterations
    ArrayListTree<String> node;

    // 3) Go through each node in the stack as long as it is not empty
    while (!stack.isEmpty()) {
        node = stack.pop();

        System.out.printf("- %s%n", node.getValue());

        // 4) Add the children of the popped element to the stack
        for (var childNode : node.getChildren()) {
            stack.push(childNode);
        }
    }
    */
}