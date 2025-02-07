void main() {
    int[] array = { 1, 3, 4, 6, 7, 8, 10, 13, 14, 18, 19, 21, 24, 37, 40, 45, 71 };
    int x = 7;

    //# Recursive solution
    int index = binarySearchRecursive(array, x, 0, array.length - 1);

    if (index > -1) {
        System.out.printf("Found x at index: %d%n", index);
        System.out.printf("- array[%d] = %d%n", index, array[index]);
    }
    else {
        System.out.println("Could not locate x within the array");
    }
}

int binarySearchRecursive(int[] array, int x, int low, int high) {
    int index;

    if (low > high) {
        return -1;
    }
    else {
        index = (low + high)/2;

        if (x == array[index]) {
            return index;
        }
        else if (x < array[index]) {
            return binarySearchRecursive(array, x, low, index - 1);
        }
        else {
            return binarySearchRecursive(array, x, index + 1, high);
        }
    }
}