import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	// convert int[] to ArrayList<Integer>
	private static ArrayList<Integer> newArrayList(int... values) {
		ArrayList<Integer> ret = new ArrayList<>();
		ret.ensureCapacity(values.length);
		for (int v : values) {
			ret.add(v);
		}
		return ret;
	}

	public static void main(String[] args) {


		System.out.println("--- Demo of default behavior ---");

		// the NoClone class does not implement Cloneable, nor does it support
		// clone(). If we try to clone it, we can't compile.

		NoClone dummyObject = new NoClone();
		// Object dummyObjectClone = dummyObject.clone(); // error!

		// The issue is that the default implementation of clone is protected.
		// So, by default, classes that do not override the clone() method
		// cannot be cloned.




		System.out.println("--- Demo of types that support clone() ---");

		UserData ud1 = new UserData(1, "user1", newArrayList(1,2,3));

		// we invoke clone to create a deep copy of ud1
		UserData ud2 = ud1.clone();

		/*
		   by default, clone() returns Object. in the UserData class, I
		   specifically changed the return type of the overriden clone() method
		   to be UserData. Other classes may not do this. If they don't, you
		   would need to use the following code:
		*/
		// UserData ud2 = (UserData) ud1.clone();

		// the clone is not the same object (prints false)
		System.out.println(ud1 == ud2);

		// but the clone is 'equivalent ot' the original object (prints true)
		System.out.println(ud1.equals(ud2));

		// here we modify the clone
		ud2.setValues(newArrayList(2,4,6));

		// we see that modifying the clone did not modify the original, so now
		// they are no longer equivalent (equals returns false)
		System.out.println(ud1.equals(ud2));




		System.out.println("--- Demo of immutable types ---");

		ImmutableData immutable1 = new ImmutableData(newArrayList(1,2,3));

		ImmutableData immutable2 = immutable1.clone();

		System.out.println(immutable1 == immutable2);
		System.out.println(immutable1.equals(immutable2));

	}
}
