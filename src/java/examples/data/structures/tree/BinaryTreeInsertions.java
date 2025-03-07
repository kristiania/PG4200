import data.structures.tree.BinaryNodeTree;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(5);
    tree.insert(7);
    tree.insert(6);

    System.out.println(tree.getRoot());
    System.out.println();
}