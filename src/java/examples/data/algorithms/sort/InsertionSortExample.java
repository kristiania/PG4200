import data.Helper;

import static data.Helper.Array.swap;
import static data.Helper.Array.arrayString;
import static data.Helper.IO.*;
import static data.RNG.randomIntegers;


//---------------------------------------------------------------------------------------------------------------------
//# Program
void main() {
    int n = 10;

    // Generate n random integers;
    int[] numbers = randomIntegers(n, -50, 50);


    // State;
    var pivot = 1;              // values to the left of index pivot are sorted;
    var operations = 0;         // count of operations performed to insert
                                // smaller numbers among sorted numbers;
    var sortedIterations = 0;   // count of iterations of sorted numbers left of pivot;


    var prefix = "int[] numbers = ";
    var suffix = ";";


    // Display current numbers before sorting algorithm is performed;
    printlnf(prefix, arrayString(numbers), suffix);


    // Perform insertion sort;
    //? for each number[i] skipping first,
    for (int i = pivot; i < n; i ++) {

        //? compare number with each element in with what is sorted left of pivot
        for (int x = pivot; x > 0; x --) {

            //? and if number we're currently at is smaller than sorted numbers
            if (numbers[x] < numbers[x - 1]) {
                //? a smaller number is swapped to the left (sorted),
                //  further on as smaller the number is
                swap(numbers, x, x - 1); operations ++;
            }
            else {
                // Display current numbers after no swap operation was performed;

                //? if no swap occurred, print result and break loop as pivot can be moved
                break;
            }
        }

        sortedIterations ++;
        pivot ++;

    }


    // Display current numbers after sorting algorithm is done sorting;
    printlnf(prefix, arrayString(numbers), suffix);


    // Statistics;
    printf("Operations performed: %d%n", operations);
    printf("Iterations from pivot to possibly zero: %d%n", sortedIterations);
}
