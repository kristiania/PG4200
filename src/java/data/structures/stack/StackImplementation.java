package data.structures.stack;


public interface StackImplementation<E>
{
    void push(E element);
    E pop();
    E peek();
}
