package data.structures;


public class Wrapper<T>
{
    private T data;

    public Wrapper(T value) {
        this.data = value;
    }

    public T get() {
        return this.data;
    }

    public void set(T value) {
        this.data = value;
    }
}
