// This class shows how you can wrap an existing Comparator implementation and
// apply some transformation to the result. This specific implementation
// reverses the results from the wrapped comparator.

// In practice you can just call:
//
//     myComparator.reversed()
//
// This is just for the sake of a simple demonstration.

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	Comparator<T> wrapped;

	public ReverseComparator(Comparator<T> wrapped) {
		this.wrapped = wrapped;
	}

	public int compare(T o1, T o2) {
		// note the negation
		return -wrapped.compare(o1, o2);
	}

}
