import data.structures.tree.BinaryNodeTree;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(100);
    tree.insert(20);
    tree.insert(10);
    tree.insert(30);
    tree.insert(200);
    tree.insert(150);
    tree.insert(300);

    var iterator = tree.inOrderIterator();

    while (iterator.hasNext()) {
        var node = iterator.next();

        System.out.println(node.getData());
    }
}