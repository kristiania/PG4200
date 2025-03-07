import static data.RNG.randomIntegers;
import static data.Helper.Array.indicesOf;
import static data.Helper.Array.arrayString;
import static data.Helper.IO.printf;
import static data.Helper.IO.println;


void main() {
    var numbers = randomIntegers(7, 0, 9);

    var array = arrayString(numbers);

    println(array);

    println(
            String.valueOf(
                getStartPositionOfNumberIndexInStringArray(array, 3)
            )
    );

}


int getStartPositionOfNumberIndexInStringArray(String array, int i) {
    if (i == 0) {
        return 1;
    }

    var indices = indicesOf(array, ",");

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
