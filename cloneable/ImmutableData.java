import java.util.ArrayList;

public class ImmutableData implements Cloneable {

	private final ArrayList<Integer> value;

	@SuppressWarnings("unchecked")
	public ImmutableData(ArrayList<Integer> unsafeValue) {

		// We clone the list because we don't want to allow indirect modifications!
		value = (ArrayList) unsafeValue.clone();

	}

	public int size() {
		return value.size();
	}

	public Integer get(int index) {
		return value.get(index);
	}

	public ImmutableData clone() {
		// While it is convention to construct a totally new object, we don't
		// actually have to since this class is immutable. In fact, its better
		// _not_ to, because copying lists can get expensive!
		return this;
	}

}
