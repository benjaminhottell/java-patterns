import java.util.ArrayList;
import java.util.Collections;

public class Main {

	private static ArrayList<VersionData> loadVersions(String... values) {
		ArrayList<VersionData> ret = new ArrayList<>();
		ret.ensureCapacity(values.length);
		for (String s : values) {
			ret.add(new VersionData(s));
		}
		return ret;
	}

	public static void main(String[] args) {

		// Scrambled versions
		ArrayList<VersionData> versions = loadVersions(
				"3.0.1",
				"0.0.1",
				"2.0.0",
				"1.5.2",
				"1.0.0",
				"2.1.10"
		);

		System.out.print("Scrambled versions: ");
		System.out.println(versions);

		// because VersionData implements Comparable, we can use
		// Collections.sort (without passing a Comparator)
		Collections.sort(versions);

		System.out.print("Sorted versions: ");
		System.out.println(versions);

		Collections.sort(versions, Collections.reverseOrder());

		System.out.print("Reversed versions: ");
		System.out.println(versions);

	}

}

