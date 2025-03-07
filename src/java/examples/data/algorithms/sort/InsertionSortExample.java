import static data.Helper.Array.arrayString;
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

    var marginLeft = 16;
    var marginRight = 16;
    var prefix = "int[] numbers = ";
    var suffix = ";";

    printlnf(marginLeft, prefix, "%s", suffix, marginRight,arrayString(numbers));


}