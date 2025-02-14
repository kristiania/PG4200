import data.structures.tree.BinaryNodeTree;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(5);
    tree.insert(2);
    tree.insert(9);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    tree.insert(7);
    tree.insert(8);
    tree.insert(6);

    var iterator = tree.postOrderIterator();

    while (iterator.hasNext()) {
        var node = iterator.next();

        System.out.println(node.getData());
    }
}