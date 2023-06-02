import java.util.ArrayList;

public class UserData implements Cloneable {

	private final int id;
	private final String name;
	private ArrayList<Integer> values;

	public UserData(int id, String name, ArrayList<Integer> values) {
		this.id = id;
		this.name = name;
		this.values = values;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Integer> getValues() {
		return values;
	}

	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}

	@Override
	public UserData clone() {

		@SuppressWarnings("unchecked")
		ArrayList<Integer> clonedValues = (ArrayList) this.values.clone();

		return new UserData(
				this.id,
				this.name,
				clonedValues);

	}

	@Override
	public boolean equals(Object oRaw) {
		if (!(oRaw instanceof UserData)) {
			return false;
		}
		
		UserData o = (UserData) oRaw;

		return o.id == this.id
			&& o.name == this.name
			&& o.values.equals(this.values);

	}

}
