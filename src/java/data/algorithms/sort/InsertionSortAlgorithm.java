package data.algorithms.sort;

import data.algorithms.sort.SortingAlgorithm;
import data.algorithms.Complexity;

import data.structures.list.ArrayList;

import java.lang.Comparable;


public class InsertionSortAlgorithm<T extends Comparable<T>>
        extends SortingAlgorithm
{
    public InsertionSortAlgorithm()
    {
        super(
                "Insertion Sort",
                Complexity.Type.Linear,     // best      time   n       (if data already sorted)
                Complexity.Type.Quadratic,  // average   time   n²
                Complexity.Type.Quadratic,  // worst     time   n²
                Complexity.Type.Constant    // auxiliary space  1
        );
    }


    //# ------------------------- Static implementations of sorting different data structures -------------------------
    static public <T extends Comparable<T>> void sort(ArrayList<T> data)
    {
        // TODO: InsertionSortAlgorithm.sort(ArrayList)
    }

    //# -------------------------
}






