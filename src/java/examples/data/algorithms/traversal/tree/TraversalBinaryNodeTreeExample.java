import data.structures.tree.BinaryNodeTree;
import data.structures.tree.node.BinaryTreeNode;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(4);
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    tree.insert(7);
    tree.insert(9);
    tree.insert(6);


    System.out.println();
    System.out.printf("Root note: %d%n", tree.getRoot().getData());

    Consumer<BinaryTreeNode<Integer>> outputNode = (node) -> {
        System.out.printf("{ %-4d | %-10s } <-- [ %-10s | %-5d | %-10s ] --> { %-10s | %-4d }%n",
                node.getLeft() != null
                        ? node.getLeft().getData()
                        : null,
                node.getLeft() != null
                        ? node.getLeft().hashCode()
                        : null,
                node.hashCode(),
                node.getData(),
                node.hashCode(),
                node.getRight() != null
                        ? node.getRight().hashCode()
                        : null,
                node.getRight() != null
                        ? node.getRight().getData()
                        : null
        );
    };


    System.out.println();
    System.out.println("In Order Iteration:");
    tree.forEach(tree.inOrderIterator(), outputNode);

    System.out.println();
    System.out.print("In Order Traversal: ");

    tree.inOrderTraversal((node) -> {
        System.out.printf("%d ", node.getData());
    });


    System.out.println();
    System.out.println();
    System.out.println("Pre Order Iteration:");
    tree.forEach(tree.preOrderIterator(), outputNode);

    System.out.println();
    System.out.print("Pre Order Traversal: ");

    tree.preOrderTraversal((node) -> {
        System.out.printf("%d ", node.getData());
    });


    System.out.println();
    System.out.println();
    System.out.println("Post Order Iteration:");
    tree.forEach(tree.postOrderIterator(), outputNode);

    System.out.println();
    System.out.print("Post Order Traversal: ");

    tree.postOrderTraversal((node) -> {
        System.out.printf("%d ", node.getData());
    });

}