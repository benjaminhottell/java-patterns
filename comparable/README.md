# Comparable

You can implement the `Comparable` interface within your type to define how objects of this type should be ordered relative to objects of that same type.

Here's how a class will look with the `Comparable` interface.

```java
public class Xyz implements Comparable<Xyz> {

    /* ... */

    @Override
    public int compareTo(Xyz o) {
        /* ... */
    }
}
```

The `compareTo` method returns an integer to communicate whether the given object `o` is less than, equal to, or greater than `this`.

- Return a negative integer (e.g. `-1`) if `this` is less than `o`
- Return zero (`0`) if `this` is equal to or equivalent to `o`
- Return a positive integer (e.g. `1`) if `this` is greater than `o`

See `VersionData.java` for an example.


## When to implement Comparable

You should only implement `Comparable` if your type can be meaningfully sorted or ordered. Suppose that your type is named `Xyz`. Ask yourself these questions:

- Is it possible for one `Xyz` to be 'equivalent to' or 'equal to' another `Xyz`?
- Does it make sense for one `Xyz` to be 'less than' or 'earlier than' another `Xyz`?
- By extension, does it make sense for one `Xyz` to be 'greater than' or 'later than' another `Xyz`?

If you answered 'no' to any of the above questions, you may not want to implement `Comparable`.

If you answered 'yes' to all of the above questions, then you should implement `Comparable` and write the `compareTo` method to express that 'less/greater than' or 'earlier/later than' or 'equal/equivalent to' relationship.

## See also

- [Comparator](../comparator)
