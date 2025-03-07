package data;


import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.fusesource.jansi.AnsiConsole;
// import static org.fusesource.jansi.Ansi.*;
// import static org.fusesource.jansi.Ansi.Color.*;

import data.structures.list.ArrayList;


public class Helper
{
    //# Fields
    //## Configuration
    static private final boolean systemInstallANSI = false;
    static private final boolean useANSI = false;


    //# Helper::Array
    static public class Array
    {
        /** XOR swaps two indices within an array
         *  <br>
         *  X = Y ^ X;<br>
         *  Y = X ^ Y;<br>
         *  X = Y ^ X;<br>
         *  <br>
         *  As xor is commutative, it is simplified to:<br>
         *  X = X ^ Y;<br>
         *  Y = X ^ Y;<br>
         *  X = X ^ Y;<br>
         *  <br>
         *  where X = array[a] and Y = array[b],
         *  and [a, b, a].forEach(index => array[index] = array[a] ^ array[b])
         *  equals a swap of integer values stored between two different indices in an array
         *
         *
         * @param array Integer array of numbers where values stored at index a and b will be swapped
         * @param a index of swap target a
         * @param b index of swap target b
         */
        static public void swap(int[] array, int a, int b) {
            for (var i : new int[] { a, b, a }) {
                array[i] = array[a] ^ array[b];
            }
        }

        /**
         *  Returns a [ ... ] string representation of an integer array of numbers
         *  <br>
         *  <br>
         *  Values are represented as comma-separated values between square brackets,
         *  with whitespace characters as padding between syntax tokens.
         *
         * @param numbers integer [] array
         * @return String Representation of integer array as a string of numerical characters.
         */
        static public String arrayString(int[] numbers) {
            return Helper.Array.arrayString(numbers, ", ");
        }

        static public String arrayString(int[] numbers, String delimiter) {
            return Arrays.toString(numbers).replaceAll(", ", delimiter);
        }

        static public int[] indicesOf(String haystack, String needle) {
            var buffer = new ArrayList<Integer>();

            // pass through count charAt
            for (int i = 0, n = haystack.length();  i < n;  i ++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    if (haystack.substring(i, needle.length()).equals(needle)) {
                        buffer.add(i);
                    }
                }
            }

            AtomicInteger n = new AtomicInteger(buffer.size());
            var output = new int[buffer.size()];

            buffer.forEach((index) -> {
                output[buffer.size() - (n.getAndDecrement())] = index;
            });

            return output;
        }
    }


    //# Helper::Text
    static public class Text
    {
        static public String join(String... segments) {
            return Helper.Text.join(", ", segments);
        }

        static public String join(String delimiter, String... segments) {
            var output = new StringBuilder(segments[0]);

            for (var segment : Arrays.stream(segments).skip(1).toList()) {
                output.append("%s%s".formatted(delimiter, segment));
            }

            return output.toString();
        }

        static public String asTextMonoSpace(String text) {
            return " ".repeat(text.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(Helper.Number.countSum(9));
    }


    //# Helper::Number
    static public class Number
    {
        static public int countSum(int target) {
            var output = 0;

            for (int x = target; x > 0; x --) {
                output += x;
            }

            return output;
        }
    }


    //# Helper::InputOutput
    static public class IO
    {
        static private PrintStream getConsoleOutputStream() {
            return Helper.useANSI
                    ? AnsiConsole.out()
                    : System.out;
        }

        static private PrintStream getConsoleErrorStream() {
            return Helper.useANSI
                    ? AnsiConsole.err()
                    : System.err;
        }

        static {
            if (Helper.useANSI && Helper.systemInstallANSI) {
                AnsiConsole.systemInstall();
            }
        }

        static public void print(String... text) {
            IO.getConsoleOutputStream().printf("%s", Helper.Text.join(text));
        }

        static public void println() {
            IO.getConsoleOutputStream().printf("%n");
        }

        static public void println(String... text) {
            IO.getConsoleOutputStream().printf("%s%n", Helper.Text.join(text));
        }

        static public void printf(String format, Object... args) {
            IO.getConsoleOutputStream().printf(format, args);
        }

        static public void printlnf(String format, Object... args) {
            IO.getConsoleOutputStream().printf(format + "%n", args);
        }

        static public void printlnf(String prefix, String format, String suffix, Object... args) {
            Helper.IO.printlnf(prefix.length(), prefix, format, suffix, suffix.length(), args);
        }

        static public void printlnf(int wsl, String prefix, String format, String suffix, int wsr, Object... args) {
            var total = 120; // 80 for smaller screens, TODO: make configurable
            var count = 0;
            var buffer = new StringBuilder(total);

            // whitespace left diff after prefix accounted for
            var wsld = wsl - prefix.length();

            if (wsld > 0) {
                buffer.append(" ".repeat(wsld));  count += wsld;
            }

            var input = format.formatted(args);

            buffer.append(prefix);  count += prefix.length();
            buffer.append(input);   count += input.length();
            buffer.append(suffix);  count += suffix.length();

            // whitespace right diff from total after suffix accounted for
            var wsrd = wsr - suffix.length();

            if (wsrd > 0) {
                if ((count + wsrd) <= total) {
                    buffer.append(" ".repeat(wsrd + (total - count - wsrd)));
                }
            }

            var output = buffer.toString();
            /*
            // var diff = total - output.length();
            TODO: make use of diff by properly handling a total size of print output

            if (diff > 0) {
                IO.getConsoleErrorStream().println("IO::printlnf(...)::warn print output larger than total set");
            }
            */

            IO.getConsoleOutputStream().println(output);
        }


    }
}
