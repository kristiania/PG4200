import data.structures.array.StaticArray;


void main() {
    var array = new StaticArray<String>(10);

    array.insert(5, "Hello");

    System.out.println(array.get(5));
}
