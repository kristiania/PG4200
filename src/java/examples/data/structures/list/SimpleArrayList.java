import java.util.ArrayList;

void main() {
    var list = new ArrayList<String>();

    list.add("Foo");
    list.add("Foo");
    list.add("Bar");

    System.out.println(list.indexOf("Foo"));
    System.out.println(list.lastIndexOf("Foo"));
}