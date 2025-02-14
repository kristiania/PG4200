import data.structures.tree.BinaryNodeTree;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(5);
    tree.insert(2);
    tree.insert(7);
    tree.insert(6);
    tree.insert(1);
    tree.insert(3);
    tree.insert(8);
    tree.insert(4);
    tree.insert(9);
    tree.insert(0);

    var iterator = tree.preOrderIterator();

    System.out.printf("Tree Root: %d%n", tree.getRoot().getData());

    while (iterator.hasNext()) {
        var node = iterator.next();

        System.out.println(node.getData());
    }
}