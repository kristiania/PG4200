package data.algorithms.search;

import data.structures.list.SinglyLinkedList;


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
}
