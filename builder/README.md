# Builder Pattern

In this example, `Book` objects are constructed with a `BookBuilder` object. While `Book`s can be instantiated directly through their constructor, the `BookBuilder` object provides a more easily readable interface. (See `Main.java` for a comparison).

## Advantages of builders (compared to lengthy constructors)

- Builders are more readable at a glance, since the method names reflect the intended purpose of each field
- Builders can have arguments added in any order
- Builders can have implicit, default arguments
- The `Book` constructor(s) can evolve independently of the rest of the code, since only the `BookBuilder` type needs to be updated

## Potential alternatives

- Provide alternative constructors in `Book`. You might have one constructor with the absolute bare minimum, and other constructors which allow for optional fields.

```java
MyType(String name) {
    /*...*/
}
MyType(String name, int foo, double baz, float bar) {
    /*...*/
}
```

- Use getters and setters in the object itself, allow the user to set the fields after constructing it. (This does not apply to immutable types, also does not apply to types that need everything in order by the time the constructor exits)
- Break the object in question into smaller objects with simpler constructors
- Use a factory of some kind to simplify the construction process (see below)

## Relationship with factories

A factory can make a builder redundant. Consider the following static factory:

```java
public class CommonBooks {
    public static Book getArtOfWar() {
        return new Book(
            "The Art of War",
            "Sun Tzu",
            null,
            -1);
    }
}
```

While `null` and `-1` placeholder values appear (which makes the code a little harder to read), the 'hard to read' stuff is wrapped within an 'easy to read' function, meaning that the 'hard' code is contained and isolated.

Or, builders and factories can work together. Consider the following static factory:

```java
public class CommonBooks {
    public static Book getArtOfWar() {
        return new BookBuilder()
            .setTitle("The Art of War")
            .setAuthor("Sun Tzu")
            .build();
    }
}
```

Factories and builders are therefore not necessarily mutually exclusive.

## In other languages

In my experience, the builder pattern rarely appears in Python. This is because Python allows you to specify default arguments, and specify which argument is which. Consider the following example:

```python
class Book:
    def __init__(self, title, author=None, color=None, year=-1):
        self.title = title
        self.author = author
        self.color = color
        self.year = year

def get_art_of_war():
    return Book(title="The Art of War", author="Sun Tzu")
```

A builder is therefore not necessary as the concerns are all addressed by Python's syntax itself.

