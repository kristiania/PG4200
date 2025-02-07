package data.algorithms.search;

import data.structures.list.SinglyLinkedList;
import data.structures.stack.ArrayListStack;


public class LinearSearch
{
    static <E> boolean search(SinglyLinkedList<E> haystack, E needle) {
        // 1) Start with the first node in the linked list
        var node = haystack.getFirstNode();

        // 2) Traverse through each node until there are no more nodes to check
        while (node != null) {
            // 2a) If the value stored in the current node being checked matches, return true
            if (node.getData().equals(needle)) {
                return true;
            }

            // 3) Set the current node to the next node, and continue the loop
            node = node.getNextNode();
        }

        // 4) If nothing was found going through each node, return false
        return false;
    }


    static <E> boolean search(ArrayListStack<E> haystack, E needle) {
        var buffer = new ArrayListStack<E>();

        boolean found = false;

        while (true) {
            buffer.push(haystack.pop());

            if (buffer.peek().equals(needle)) {
                found = true;
                break;
            }

            if (haystack.isEmpty()) {
                break;
            }
        }

        while (!buffer.isEmpty()) {
            haystack.push(buffer.pop());
        }

        return found;
    }

    public static void main(String[] args) {
        var stack = new ArrayListStack<>();

        stack.push(3);
        stack.push(4);
        stack.push(123);
        stack.push(23);
        stack.push(3);

        System.out.println(LinearSearch.search(stack, 4));
    }
}
