import static data.Helper.Array.arrayString;
import static data.Helper.Array.swap;
import static data.Helper.IO.printlnf;
import static data.RNG.randomIntegers;


/*
    Insertion Sort Algorithm

    1)  Start by setting a pivot as index 1 which splits linear structure into two, where:
        - all indices left of pivot is sorted
        - all indices right of pivot is unsorted

    2)  Before each pivot-move to the right,
        compare number at pivot with value at one index less:
            if number at pivot is less than number to the left,
                swap places, moving the lesser value to the left
               as long as

*/
void main() {
    var numbers = randomIntegers(10, 0, 99);

    printlnf("int[] numbers = ", "%s", ";", arrayString(numbers));

    quickSort(numbers);

    printlnf(16, "", "%s", ";", 1, arrayString(numbers));


}

void quickSort(int[] numbers) {
    quickSort(numbers, 0, numbers.length - 1 );
}

void quickSort(int[] numbers, int low, int high) {
    if (low >= 0 && low < high) {
        var pivot = partition(numbers, low, high);

        quickSort(numbers, low, pivot);
        quickSort(numbers, pivot + 1, high);
    }
}

int partition(int[] numbers, int low, int high) {
    var pivot = numbers[low];
    var left = low - 1;
    var right = high + 1;

    while (true) {
        do {
            left = left + 1;
        } while (numbers[left] < pivot);

        do {
            right = right - 1;
        } while (numbers[right] > pivot);

        if (left >= right) {
            return right;
        }

        swap(numbers, left, right);
    }
}