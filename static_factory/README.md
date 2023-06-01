# Static Factories

Static factories are a variation on the broader factory theme. It is the least flexible of them all, but also the simplest to implement.

As the name suggests, static factories are "static" in the sense that they are not instantiated and thus are not treated as objects.

I recommend static factories when there is always going to be a single, objectively 'correct' way to instantiate an object, and you will never need to modify its behavior. This occurs very rarely in practice, and is generally reserved for mathematical things like geometric shapes.

See `GeometryFactory.java.` for a short example.


## Embedding within classes

You don't have to create a standalone static factory class. You can instead embed static construction methods within classes.

See `Circle.java` for an example of this.


## Singletons

A static factory class could be converted into a singleton by making the static construction methods into nonstatic methods.

