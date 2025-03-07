package data.algorithms.search;

import data.structures.list.SinglyLinkedList;
import data.structures.queue.SinglyLinkedListLinearQueue;
import data.structures.stack.ArrayListStack;
import data.structures.stack.SinglyLinkedListStack;


/*
    Collection of different linear search algorithms,
    provided as static methods where each signature is as follows:
        DataStructure<E> hay[type], E needle

    For example, to search through the respective data structures:
        - ArrayList
        - SinglyLinkedList
        - ArrayListQueue
*/
public class LinearSearchAlgorithm
{
    //# Search through a singly linked list (haystack) for a search  term (needle)
    static <E> boolean search(SinglyLinkedList<E> haystack, E needle) {
        // 1) Start with the first node in the linked list provided
        var node = haystack.getFirstNode();

        // 2) Traverse through each node until there are no more nodes to check
        while (node != null) {
            // 2a) If the value stored in the current node being checked matches, return true
            if (node.getData().equals(needle)) {
                return true;
            }

            // 3) Set the current node to the next node, and continue the loop condition check
            node = node.getNextNode();
        }

        // 4) If nothing was found going through each node, return false
        return false;
    }


    //# Search through an array list stack (haystack) for a search  term (needle)
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


    //# Search through a singly linked list stack
    static <E> boolean search(SinglyLinkedListStack<E> haystack, E needle) {
        // if the haystack is empty, the needle is not within the haystack, exit early
        if (haystack.isEmpty()) {
            return false;
        }

        E cursor; // what we are currently looking for

        // Go through each value stored in the stack
        // by pop()-ing values one-by-one until empty
        while (!haystack.isEmpty()) {
            // look at the first value in the stack
            cursor = haystack.pop();

            // did we find what we are looking for?
            if (cursor.equals(needle)) {
                return true;
            }
        }

        // not found, so needle is not within haystack
        return false;
    }


    //# Search through a singly linked list linear queue
    static <E> boolean search(SinglyLinkedListLinearQueue<E> hayqueue, E needle) {
        if (hayqueue.isEmpty()) {
            return true;
        }

        E cursor;

        while (!hayqueue.isEmpty()) {
            cursor = hayqueue.dequeue();

            if (cursor.equals(needle)) {
                return true;
            }
        }

        return false;
    }
}
