# `PG4200`

> Algorithms and Data Structures

---

Make sure you have IntelliJ 2024 or 2025EAP installed to make use of newer Java JDK features in this repository.

Using `JetBrains Toolbox` to manage versions of IntelliJ is recommended. 

---

# Getting started

In IntelliJ, create a new project from version control, using the following URL:
- `https://github.com/kristiania/PG4200`

---

This repository uses Java 23 JDK.

Use the `src/java/sandbox/` directory to test and explore data structures and algorithms.

**Work in progress**, expect commits often, so make sure to git pull often!

---

## Directory Structure

> `./input/`
> 
> Example input

> `./data/algoritms/`
> 
> 

> `./data/structures/`
> 
> - `array/`
>   - `StaticArray`
> - `Graph`
> - `List`
>   - `ArrayList`
>   - `SinglyLinkedList`
>   - `DoublyLinkedList`
>   - `CircularSinglyLinkedList`
>   - `CircularDoublyLinkedList`
> - `Stack`
>   - `ArrayListStack`
> - `Tree`
>   - `BinaryNodeTree`
> - `Queue`
>   - `ArrayListLinearQueue`
>   - `CircularQueue`
>   - `PriorityQueue`
>   - `Deque`

---

> PS! `DSA` is short for `Data Structures and Algorithms`

---

### Programs vs. Classes

Using the new language preview feature in JDK 23,
programs in this repository strictly follows the following code structure:

```java
void main() {
    // program code
}
```

A program ...
- does not have a `package`-statement at the top
- does not contain a public class declaration
- is meant to be run a program that uses data structures and algorithms within this repository

Use the `src/java/sandbox/`-directory to write your own programs.

Check out `src/jave/examples/sandbox/Program.java` for an example. 

---

## Contributions

If you want to contribute implementations, fixes or examples, do so as following:

1) Fork this repository
2) Create a new branch
3) Commit changes
4) Create a pull request via GitHub