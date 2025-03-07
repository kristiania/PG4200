void main() {
    int[] array = { 5, 2, 7, 1, 8, 9, 3, 11, 0 };
    int x = 3;

    boolean found = false;
    int index = -1;

    System.out.println("Parameters:");
    System.out.printf("- array = %s%n", Arrays.toString(array));
    System.out.printf("- x = %d%n", x);

    System.out.println("Performing search:");

    for (int i = 0, n = array.length; i < n; i ++) {
        System.out.printf("- Iteration %d:%n", i + 1);

        if (array[i] == x) {
            System.out.printf("-- Found what we are looking for at index = %d%n", i);

            found = true;
            index = i;

            break;
        }
    }

    System.out.println("Search finished!");

    System.out.println("Results:");

    if (found) {
        System.out.printf("array[%d] = %d%n", index, array[index]);
    } else {
        System.out.println("Did not find what we were looking for during search");
    }
}
