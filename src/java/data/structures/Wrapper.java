package data.structures;


import java.util.Optional;

public class Wrapper<T>
{
    //# Fields
    private T data;


    //# Constructors
    public Wrapper(T value) {
        this.data = value;
    }


    //# Getter-method
    public T get() {
        return this.data;
    }

    public Optional<T> optional() {
        return Optional.ofNullable(this.get());
    }


    //# Setter-method
    public void set(T value) {
        this.data = value;
    }

    public T replace(T value) {
        var buffer = this.get();

        this.set(value);

        return buffer;
    }


    //# Methods
    public void clear() {
        this.data = null;
    }
}
