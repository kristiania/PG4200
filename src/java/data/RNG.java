package data;


public class RNG
{
    static public int randomInteger(int max) {
        return RNG.randomInteger(0, max);
    }

    static public int randomInteger(int min, int max) {
        return ((int) Math.floor(Math.random()*(max - min))) + min;
    }

    static public int[] randomIntegers(int n, int min, int max) {
        // Make sure at least one random integer is returned
        n = Math.max(1, n);

        var output = new int[n];

        for (int i = 0; i < n; i ++) {
            output[i] = RNG.randomInteger(min, max);
        }

        return output;
    }
}
