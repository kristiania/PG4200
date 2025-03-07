package data.algorithms.sort;

import data.algorithms.sort.SortingAlgorithm;
import data.algorithms.Complexity;

import data.structures.list.ArrayList;

import java.lang.Comparable;


public class QuickSortAlgorithm<T extends Comparable<T>>
        extends SortingAlgorithm
{
    public QuickSortAlgorithm()
    {
        super(
                "Quick Sort",
                Complexity.Type.Logarithmic,    // best      time   n log(n)
                Complexity.Type.Logarithmic,    // average   time   n log(n)
                Complexity.Type.Quadratic,      // worst     time   n²
                Complexity.Type.Linear          // auxiliary space  n
        );
    }


    //# ------------------------- Static implementations of sorting different data structures -------------------------
    static public <T extends Comparable<T>> void sort(ArrayList<T> data)
    {
        // TODO: QuickSortAlgorithm.sort(ArrayList)
    }

    //# -------------------------
}






