package data.algorithms.sort;

import data.Helper;
import data.algorithms.Complexity;
import data.structures.list.ArrayList;

/*

*/
import java.util.Comparator;


/** Bubble Sort Algorithm
 *  <br>
 *
 *
 * @param <T> The kind of data that will be sorted using the bubble sort algorithm.
 */
public class BubbleSortAlgorithm<T extends Comparable<T>>
        extends SortingAlgorithm
{
    public BubbleSortAlgorithm() {
        super(
                "Bubble Sort",
                Complexity.Type.Quadratic,  // time     n²
                Complexity.Type.Constant    // space    1
        );
    }


    //# ------------------------- Static implementations of sorting different data structures -------------------------
    static public <T extends Comparable<T>> void sort(ArrayList<T> data) {

    }
    //# -------------------------
}
