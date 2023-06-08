# Comparator

You can implement the `Comparator` interface to define a new way to compare two objects of type `T` (where `T` is any `Object`).

The `Comparator<T>` interface has one method that you need to override: `int compare(T o1, T o2)`

Once you do that, you can pass your `Comparator` object to certain methods, such as `ArrayList.sort` to override the default ordering behavior.

Or, you can accept `Comparator` objects in your own functions to maximize flexibility (instead of relying on the comparatively less flexible `Comparable` implementation).

If you have a class that already implements `Comparable`, then you can call `Comparator.naturalOrder()` to get a trivial `Comparator` that just calls the class's `Comparable` implementation.

If you're writing a function that orders items in some way, I recommend providing two variations of that function:

1. A variation that accepts multiple `Comparable` objects
2. A variation that accepts multiple objects and one `Comparator`.

That way you have the best of both worlds. The first variation is brief and simple, since you can just implicitly use the 'natural ordering' of the object. The second variation is more flexible and verbose, allowing your function to be adapted to more situations.

The first variation should forward all arguments to the second variation, with the `Comparator` being `Comparator.naturalOrder()`.


## Transforming Comparators

Because `Comparator`s are objects, you can write decorators/wrappers for them. See the `ReverseComparator.java` file for an example.

You can also call `.reversed()` on any Comparator object to immediately reverse it.


## Tips for writing a Comparator

- Consider using heuristics to skip expensive comparisons
    - Objects are usually equal to themselves, so if `o1 == o2`, then you can immediately return `true`
    - If the two objects have different `hashCode()` values, then they are definitely not equal to each other (but the opposite isn't true, think about hash collisions)
- Call upon other, already implemented comparison operations to prevent code duplication
    - You don't need to reinvent how to compare `String` values

