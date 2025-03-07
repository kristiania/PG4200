void main() {
    int[] array = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
    var x = 64;

    boolean found = false;
    int index = -1;

    int low = 0;
    int high = array.length - 1;

    while (!found) {
        index = (low + high)/2;

        if (low > high) {
            break;
        }

        if (x == array[index]) {
            found = true;
        }
        else if (x < array[index]) {
            high = index - 1;
        }
        else {
            low = index + 1;
        }
    }

    if (found) {
        System.out.printf("Found x at index = %d%n", index);
    }
    else {
        System.out.println("Did not find x within the array");
    }
}