package exercises;

import static data.Helper.IO.printf;
import static data.Helper.IO.println;


public abstract class ExerciseTest
{
    static {
        println("Exercise Test:");
    }

    public ExerciseTest(String description) {
        printf("Description: %s", description);
    }


}
