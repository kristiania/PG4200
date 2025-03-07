package data.structures;

import data.Data;


/**
 * Non-primitive linear or non-linear data structure
 *
 * @param <T> The type of data structure
 */
public abstract class DataStructure<T>
{


    abstract boolean isLinear();
    abstract boolean isStatic();

    enum Type {
        Array,
        Graph,
        List,
        Queue,
        Stack,
        Tree,
    };

    abstract DataStructure.Type getType();
}
