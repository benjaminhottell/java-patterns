# Static Utility Class

A static utility class is a class that only has static methods, and does not need to be instantiated.

Here are some situations where you might want a static utility class:

- You have a bunch of small, reusable, stateless functions (like the ones found in the built in `Math` class)
- You are managing application-wide or global state (e.g. managing threads, logging, `System.out`, ...)

The commonality between these cases is that they don't fit cleanly into a OOP paradigm (other than maybe the singleton pattern).


## Naming

Personally, I tend to name these classes `XyzHelper` where `Xyz` is the general topic of the static methods. So, a static utility class centered around arrays would be named `ArrayHelper`.

Alternatively, you could also name your class the plural form of `Xyz`. This is the convention that the Java built-in libraries tend to follow. (See `Arrays`, `Collections`, etc.)

I don't believe there is a single 'correct' naming function, but try to be consistent within a project!


## Difference from static factories

A static factory is generally just for creating instances of a class, while a static utility class is generally just for functionality that doesn't fit cleanly into OOP patterns.

In practice the line can get a little bit blurry, but that's true of most patterns.


## Final with private constructor

If a class only has static methods, you should consider giving it a `private` constructor and setting the class to `final`.

```java
public final class StaticClass {
    private StaticClass() {
    }
}
```

This isn't technically necessary, but it can prevent people from doing nonsensical things like extending `Math` or instantiating an `ArrayHelper`.
