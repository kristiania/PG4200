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
    printArray(prefix, numbers, suffix);
    printNewLine();

    // printFormattedArray(pre);


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

                // Display current numbers after a swap operation was performed;
                printSwapResult(numbers, pivot, x - 1, x);
            }
            else {
                // Display current numbers after no swap operation was performed;

                //? if no swap occurred, print result and break loop as pivot can be moved
                printNoSwapResult(numbers, pivot, x);
                break;
            }
        }

        sortedIterations ++;
        pivot ++;

    }

    println();


    // Display current numbers after sorting algorithm is done sorting;
    printArray(prefix, numbers, suffix);


    // Statistics;
    printf("Operations performed: %d", operations);
    printf("Iterations from pivot to possibly zero: %d", sortedIterations);
}


//---------------------------------------------------------------------------------------------------------------------
//# Helper-methods
void printArray(int[] numbers) {
    printArray("array = ", numbers, ";");
}

void printArray(String prefix, int[] numbers, String suffix) {
    printf("%s%s%s", prefix, arrayToString(numbers), suffix);
}

void printArray(String prefix, String array, String suffix) {
    printf("%s%s%s", prefix, array, suffix);
}


void printFormattedArray(int whitespace, String prefix, int[] numbers, String suffix) {
    if (prefix.length() <= whitespace) {
        printArray(
                "%s%s".formatted(
                        " ".repeat(whitespace - prefix.length()),
                        prefix
                ),
                numbers,
                suffix
        );
    }
}

void printFormattedArray(int whitespace, String array) {
    printFormattedArray(whitespace, "", array, "");
}

void printFormattedArray(int whitespace, String prefix, String array, String suffix) {
    if (prefix.length() <= whitespace) {
        printArray(
            "%s%s".formatted(
                    " ".repeat(whitespace - prefix.length()),
                    prefix
            ),
            array,
            suffix
        );
    }
}


String arrayToString(int[] array) {
    return Arrays.toString(array);
}


int getStartPositionOfNumberIndexInStringArray(String array, int i) {
    if (i == 0) {
        return 1;
    }

    var indices = Helper.Array.indicesOf(array, ",");

    for (int x = 0, n = indices.length - 1; x < n; x ++) {

        var a = array.substring(indices[x], indices[x + 1]);
        var b = a.trim();
        var c = String.valueOf(i);

        printf(a);
        printf(b);
        printf(c);

    }

    return 0;
}

void printSwapResult(int[] numbers, int pivot, int a, int b) {

    var array = arrayToString(numbers)
            .replace(", ", ",   ")
    ;

    array = array.substring(0, pivot - 1) + array.substring(pivot)


            .replaceFirst(
                    ",   %d,".formatted(numbers[a]),
                    ", < %d,".formatted(numbers[a])
            )
            .replace(
                    "%d,   %d".formatted(numbers[a], numbers[b]),
                    "%d <> %d".formatted(numbers[a], numbers[b])
            )
    ;

    printFormattedArray("int[] numbers = ".length(),
            "<<", array, " < (pivot %03d) swapped %s with %s".formatted(
                    pivot,
                    "[numbers[%02d] = %02d]".formatted(a, numbers[a]),
                    "[numbers[%02d] = %02d]".formatted(b, numbers[b])
            )
    );
}

void printNoSwapResult(int[] numbers, int pivot, int x) {
    var array = arrayToString(numbers)
            .replace(", ", ",   ")
            .replaceFirst(
                    ",   %d,".formatted(numbers[x]),
                    ", < %d,".formatted(numbers[x])
            )
            .replaceFirst(
                    "%d,   ".formatted(numbers[pivot]),
                    "%d || ".formatted(numbers[pivot])
            )
    ;

    printFormattedArray("int[] numbers = ".length(),
            "| ", array, " %s".formatted(x == pivot ? "| (pivot %03d)".formatted(pivot) : "|")
    );
}


void printNewLine() {
    println();
}