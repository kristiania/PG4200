import data.structures.Wrapper;
import data.structures.stack.SinglyLinkedListStack;
import data.structures.tree.BinaryNodeTree;
import data.structures.tree.node.BinaryTreeNode;


void main() {
    var tree = new BinaryNodeTree<Integer>();

    tree.insert(5);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    var stack = new SinglyLinkedListStack<BinaryTreeNode<Integer>>();
    var node = new Wrapper<BinaryTreeNode<Integer>>(tree.getRoot());

    while (node.get() != null || !stack.isEmpty()) {
        while (node.get() != null) {
             stack.push(node.get());

             node.set(node.get().getLeft());
        }

        node.set(stack.pop());

        System.out.println(node.get().getData());

        node.set(node.get().getRight());
    }
}