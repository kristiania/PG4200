import static data.Helper.IO.*;
import static data.RNG.randomInteger;


void main() {
    var n = 10;

    // Generate n random integers
    int[] numbers = new int[n];

    for (int i = 0; i < n; i ++) {
        numbers[i] = randomInteger(-10, 10);
    }


    // Print out random numbers before being sorted
    printf("int[] numbers[%s]%n", Arrays.toString(numbers));

    // Perform bubble sort
    var iterations = 0;     // Amount of times we have gone through each number
    var operations = 0;     // Amount of operations performed on each number
    boolean swap;           // If a swap has been performed or not during an iteration

    while (true) {
        //  before going through each number,
        //  we keep track of if a swap has happened or not
        //  after going through each number
        swap = false;

        //  n minus iterations allows us to skip
        //  already sorted values as the biggest value will always
        //  bubble up all the way to the end of the array
        for (int i = 0; i < (n - iterations) - 1; i ++) {
            if (numbers[i] > numbers[i + 1]) {
                // xor swap numbers[i] and numbers[i+1]
                for (int j : new int[] { i, i + 1, i }) {
                    numbers[j] = numbers[i + 1] ^ numbers[i];
                }

                operations ++;
                swap = true;
            }
        }

        //  if no swap occurs the numbers are all sorted,
        //  we break out of the outer while loop
        if (!swap) {
            break;
        }

        //  We keep track of iterations of all numbers
        //  as we can use it as a count of currently sorted numbers
        iterations ++;
    }


    // Print out numbers after being sorted
    printf("int[] numbers[%s]%n", Arrays.toString(numbers));
    printf("Sorted after %d swap operations%n", operations);
}
