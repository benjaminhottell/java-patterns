# Null Object Pattern

Consider the following interface:

```java
public interface MessageAction {
	void sendMessage(String message);
}
```

Now suppose that we take the following convention throughout our codebase: whenever you encounter a `null` `MessageAction`, treat it as though it were a no-op.

Or, in other words, only invoke the `sendMessage` function of a `MessageAction` object if the object is non-`null`.

```java
void someFunction(MessageAction m) {
    String msg = /* ... */;
    if (m != null) {
        m.sendMessage(m);
    }
}
```

The issue here is that now we have to check for `null`, and handle `null` values as a special case (even though the 'special' functionality is quite mundane!)

Ideally we would not have to worry about such special cases in our code. And, ideally, the `null` behavior would be centralized such that its not duplicated throughout the codebase.

The null object pattern normalizes the special `null` case. The 'null' object represents a `null` value, without actually literally being `null`. This way, we can write code without worrying about `null` objects while still having the ability to have 'null functionality'.

You shouldn't mix `null` values and 'null' objects. The null object is intended to stand in for the cases where you'd be tempted to return `null`.

