import data.structures.tree.BinaryNodeTree;
import data.structures.tree.node.BinaryTreeNode;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(100);
    tree.insert(20);
    tree.insert(10);
    tree.insert(30);
    tree.insert(200);
    tree.insert(150);
    tree.insert(300);

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