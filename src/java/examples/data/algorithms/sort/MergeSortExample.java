import static data.Helper.Array.arrayString;
import static data.Helper.IO.println;
import static data.RNG.randomIntegers;


void main()
{
    var n = 10;
    var numbers = randomIntegers(n, 0, 99);

    println(arrayString(numbers));

    mergeSort(numbers, n);

    println(arrayString(numbers));
}


void mergeSort(int[] input, int n)
{
    if (n > 1) {
        int split = n/2;

        int[] left = new int[split];
        int[] right = new int[n - split];

        System.arraycopy(input, 0, left, 0, split);
        System.arraycopy(input, split, right, 0, n - split);

        mergeSort(left, split);
        mergeSort(right, n - split);

        merge(input, left, right, split, n - split);
    }
}


void merge(int[] input, int[] left, int[] right, int leftSize, int rightSize)
{
    int i = 0, j = 0, k = 0;

    while (i < leftSize && j < rightSize) {
        if (left[i] <= right[j]) {
            input[k ++] = left[i ++];
        }
        else {
            input[k ++] = right[j ++];
        }
    }

    while (i < leftSize) {
        input[k ++] = left[i ++];
    }

    while (j < rightSize) {
        input[k ++] = right[j ++];
    }
}