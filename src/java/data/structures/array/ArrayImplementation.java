package data.structures.array;

import java.util.Optional;
import java.util.function.Consumer;


public interface ArrayImplementation<E>
        extends Iterable<E>
{
    //# Read

    /** Returns the element stored at index provided within the array,
     *  returns null if nothing was found, or,
     *  what element would be located given that index within the array.
     *  <br><br>
     *  A null return value means that a value could not be extracted
     *  from within the data structure given the index provided
     *
     * @param index placement offset within the array, 0-based
     * @return E element stored at index within the array
     */
    E get(int index);


    /** Helper-method to use Optional to operate on values retrieved from the array
     *
     * @param index which element to retrieve from the array given index within bounds
     * @return Optional E for handling null values
     */
    default Optional<E> getOptional(int index) {
        return Optional.ofNullable(this.get(index));
    }


    /** Returns the size of the array; If the data structure is static,
     *  size will return the size of the whole data structure, filled or not,
     *  whereas non-static data structures will return current size of data structure
     *  <br><br>
     *  Default implementation is linear,
     *  so it is highly recommended to override this method.
     *
     * @return int size of the array data structure
     */
    default int size() {
        int i = 0, n = 1024*1024*2;

        while (i < n) {
            try{
                var _ = this.get(i ++);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        return i;
    }


    //# Update
    /** Sets an index within the array to be that of the element given,
     *  if any value was stored there before, it is now gone.
     *  <br>
     *  Use replace() if you need the data that was stored before set.
     *
     * @param index which index to directly set as element provided
     * @param element which will be set as the element at the given index
     */
    void set(int index, E element);


    /** Inserts an element at a given index,
     * and shifts all elements at index to the right one over
     * <br><br>
     * May cause data loss as an element may be pushed outside the array
     * if the implementation of an array allows such to happen.
     * <br><br>
     * Default implementation does a linear index shift by using set(),
     * whereas a custom @override implementation
     * should take push through traversal into consideration.
     *
     * @param index where to insert an element
     * @param element element that will be inserted at given index
     */
    default void insert(int index, E element) {
        int n = this.size();

        while ((n --) > index) {
            this.set(n, this.get(n - 1));
        }

        this.set(index, element);
    }

    /** Replaces an element at a give index, and returns the replaced element;
     * <br><br>
     *  Unlike `insert(index, element)`,
     *  a `replace(index, element)` does not cause a shift which may cause data loss.
     *
     * @param index where to replace an element
     * @param element element that will replace element at given index
     * @return E element that was replaced
     */
    default E replace(int index, E element) {
        var old = this.get(index);

        this.set(index, element);

        return old;
    }


    //# Search
    /**
     * Searches for first element within the array that matches element given
     * and returns index position
     * <br>
     * @param element E
     * @return int index position if found, -1 if not
     */
    int indexOf(E element);


    /**
     * Searches for first element within the array that matches element given
     * and returns index position
     * <br>
     * @param element E
     * @return int index position if found, -1 if not
     */
    int lastIndexOf(E element);


    /** Helper-method that allows to easily check for:
     *  existing elements within data structure
     *  <br><br>
     *  Simply checks if indexOf(element) returns larger than or equal to 0,
     *  and returns true if element found to be contained within the data structure,
     *  and false if the given element is not contained within this array data structure
     *
     * @param element what to look for within the array comparison-wise
     * @return boolean if element given is found to be contained within the array, true, if not, false
     */
    default boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }


    /** Traversal method to run a function that
     *  for each element within the array provided as input to the function,
     *  allowing us to perform functionality per element within the array,
     *  runs the function with each element provided using the default iterator.
     *  <br><br>
     *  For arrays, the default iteration would be to start at index 0 and
     *  loop through each element given until reaching
     *  the total size of the (array) data structure,
     *  as in, run function with each element as input.
     *
     * @param function lambda or method that follows the signature void f(E element)
     */
    default void forEach(Consumer<? super E> function) {
        for (int i = 0, n = this.size(); i < n; i ++) {
            this.getOptional(i).ifPresent(/*run*/function);
        }
    }
}
