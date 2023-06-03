# Singleton

A singleton class has exactly one instance. Other classes cannot create more instances of this class.

The singleton pattern is perhaps one of the most controversial patterns. I will discuss some of its criticisms after showing you what it is. (See the weaknesses section below)

Here is an example of a singleton:

```java
public class SimpleSingleton {
    private static SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}
```

## Lazy singleton

One weakness in the code above is that the singleton is always constructed when the class is loaded, regardless of whether we needed it.

If the singleton constructor is expensive, it may make sense to construct it only during the first request.

```java
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

## Weaknesses of the singleton

### Nonobvious dependencies

Because the singleton is globally accessible, classes all throughout the codebase can depend on that singleton in nonobvious ways.

Consider this code in `FarFlungClass.java`:

```java
public void doSomethingObscure() {
    /* ... */
    NuclearReactorManager.getInstance().doImportantThing();
    /* ... */
}
```

`FarFlungClass` depends on `NuclearReactorManager`, yet that relationship is tucked away and hidden inside of `doSomethingObscure`. This is a recipe for confusion sometime down the line.

Also, `FarFlungClass` depends on `NuclearReactorManager` being a singleton with a `getInstance` method. If we decide to change `NuclearReactorManager` into an interface with polymorphism down the line, we end up breaking `FarFlungClass`! (And all the other far-flung classes throughout the codebase...)

To combat this, I recommend that most classes pretend that the singleton is not actually a singleton. They accept the singleton object as though it were any other object.

The revised `FarFlungClass` would look like this:

```java
FarFlungClass(NuclearReactorManager reactor) {
    this.reactor = reactor;
}

public void doSomethingObscure() {
    /* ... */
    this.reactor.doImportantThing();
    /* ... */
}
```

Now the dependency on `NuclearReactorManager` is well-known, and does not depend on `NuclearReactorManager` being a singleton.


### Difficult to test

Because singletons have a single, static instance that survives the duration of the process, unit testing becomes significantly more difficult.

Unit tests are meant to be wholly independent from each other, yet a singleton will carry over its state from prior unit tests.

This can be partially mitigated by introducing some way to reset the singleton's state, but then how do you know that the state was correctly reset?


### Violating the single responsibility rule

The single responsibility rule (or principle) states that a class should have exactly one responsibility. That is, it should be responsible for exactly one task.

It seems as though singleton classes violate this principle because they have two simulatenous responsibilities:

1. Implementing the behavior of the singleton instance itself
2. Implementing how the singleton instance is acquired


## Personal Opinion

I rarely use singletons in practice. It feels as though the singleton pattern simultaneously has the weaknesses of being object-oriented yet also the weaknesses of being static.

If something deserves to be `static`, then I go all in and make it `static`. (See static utility class, or static factory)

If something deserves to be an object, then I go all in and make it into a non-static object.

I included singleton in this repository not because I think you should use it, but because its widely taught and included in discussions about design patterns in general.

