# Cloneable

The `Cloneable` interface allows you to signal that your class supports the `clone` method.

All objects have a `clone` method, though not all objects provide a supporting implementation for it. The default implementation is protected, so you cannot call it. (Or, if it isn't protected, it will most likely throw `CloneNotSupportedException`)

Implementing `Cloneable` signals that your class...

1. Implements a `clone()` method
2. Made the `clone()` method `public`
3. Does not throw `CloneNotSupportedException` when the `clone()` method is called

Technically, you don't need to implement `Cloneable` if you've met the above criteria. And, you can implement the `Cloneable` interface without satisfying the above criteria. The interface is intended more like a marker or a 'promise' that you've satisfied the above criteria.


## Deep copy vs shallow copy

A **shallow copy** occurs when an object is cloned (copied), but its fields or contained elements are not.

Here is an example of a shallow copy:

```
ArrayList<UserData> shallowCopy(ArrayList<UserData> list) {
    ret = new ArrayList<UserData>();
    for (int i = 0; i < list.size(); ++i) {
        ret.append(list.get(i));
    }
    return ret;
}
```

Note that each `UserData` object is now contained in both lists. While the list was copied, the elements within the list were not.

A **deep copy** occurs when all fields and contained elements are _also_ cloned.

```
ArrayList<UserData> deepCopy(ArrayList<UserData> list) {
    ret = new ArrayList<UserData>();
    for (int i = 0; i < list.size(); ++i) {
        ret.append(list.get(i).clone()); // members are cloned!
    }
    return ret;
}
```


## Cloning immutable objects

Immutable objects do not need to be cloned, since they cannot be changed. Passing around a clone of an immutable object is functionally identical to passing around the immutable object itself.

So, it is more performant to skip the cloning altogether.

You can formalize this with the following no-op `clone` implementation:

```java
@Override
public Object clone() {
    return this;
}
```

Please note that your object must be _totally_ immutable, meaning that none of its fields can be directly accessed and there are no methods that change its state aside from its constructor. Also, all of its fields/contained elements must not be accessible to another object (otherwise, they could be indirectly mutated).

Java's documentation states a preference that `x != x.clone()`. This is not a binding requirement, and this is a valid case to ignore that requirement.

