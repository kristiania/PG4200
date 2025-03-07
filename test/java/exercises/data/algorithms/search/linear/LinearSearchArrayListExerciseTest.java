package exercises.data.algorithms.search.linear;

import data.structures.list.ArrayList;
import exercises.ExerciseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junitpioneer.jupiter.DisableIfTestFails;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


@DisableIfTestFails
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Create a linear search implementation using ArrayList")
class LinearSearchArrayListExerciseTest
        extends ExerciseTest
{
    static private final String pkg = "exercises.data.algorithms.search.linear";
    static private final String identifier = "ExerciseLinearSearchArrayList";

    //# Constructor
    public LinearSearchArrayListExerciseTest() {
        super("Test code that performs a linear search on an ArrayList data structure");
    }

    //# Test Fields
    private ArrayList<Integer> list1;
    private ArrayList<String> list2;

    //# Setup
    @BeforeEach
    void setUp() {
        // Initializing the lists before each test
        list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");
        list2.add("cherry");
    }

    @AfterEach
    void tearDown() {
        // Clean up resources
        list1.clear();
        list2.clear();
    }


    //# Helper-methods
    /** make sure this is never used within `getTestClass`() as this method depends on it */
    protected boolean doesTestClassExist() {
        try {
            if (this.getTestClass().isAnonymousClass() || this.getTestClass().isLocalClass()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            return false;
        }

        return false;
    }


    /** Gets a raw class abstraction from package and identifier */
    private Class<?> getTestClass() throws ClassNotFoundException {
        return Class.forName("%s.%s".formatted(pkg, identifier));
    }


    /** Given a class abstraction for instantiation,
     *  i.e. java.lang.Class, run main method as entry point.
     **/
    private void runMainStaticMethod(Class<?> cls) {
        try {
            if (this.mainStaticMethodExists(cls)) {
                // TODO: finish up exercise test framework for use
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean mainStaticMethodExists(Class<?> cls) {
        return mainStaticMethod(cls) == null;
    }

    private Method mainStaticMethod(Class<?> cls) {
        try {
            return cls.getMethod("main", String[].class);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    @Order(1)
    @DisplayName("Task 1: Create public java class with main method at correct location")
    void createJavaFile() {
        try {
            Class<?> cls = getTestClass();

        } catch (ClassNotFoundException e) {
            fail("Class named \"%s\" is not located at: %s%n".formatted(identifier, "java.%s".formatted(pkg)));
        }

        System.out.println("task1");
    }

    @Test
    @Order(2)
    @DisplayName("Task 2: Create static method")
    void createStaticMethod() {
        System.out.println("task2");
    }

    @Test
    @Order(3)
    @DisplayName("Task 3: Create a linear search method")
    void testLinearSearch() throws Exception {
        Class<?> cls = getTestClass();
        Method linearSearchMethod = cls.getMethod("linearSearch", ArrayList.class, Object.class);

        // Test searching for an integer in list1
        int result1 = (int) linearSearchMethod.invoke(null, list1, 4);
        assertEquals(3, result1); // 4 is at index 3

        int result2 = (int) linearSearchMethod.invoke(null, list1, 6);
        assertEquals(-1, result2); // 6 not found

        // Test searching for a string in list2
        int result3 = (int) linearSearchMethod.invoke(null, list2, "banana");
        assertEquals(1, result3); // "banana" at index 1

        int result4 = (int) linearSearchMethod.invoke(null, list2, "pear");
        assertEquals(-1, result4); // "pear" not found
    }
}