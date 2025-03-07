package data.algorithms.sort;

import data.algorithms.sort.SortingAlgorithm;
import data.algorithms.Complexity;

import data.structures.list.ArrayList;

import java.lang.Comparable;


public class MergeSortAlgorithm<T extends Comparable<T>>
        extends SortingAlgorithm
{
    public MergeSortAlgorithm()
    {
        super(
                "Merge Sort",
                Complexity.Type.Logarithmic,    // time     n log(n)
                Complexity.Type.Linear          // space    n
        );
    }


    //# ------------------------- Static implementations of sorting different data structures -------------------------
    static public <T extends Comparable<T>> void sort(ArrayList<T> data)
    {
        // TODO: MergeSortAlgorithm.sort(ArrayList)
    }

    //# -------------------------
}






