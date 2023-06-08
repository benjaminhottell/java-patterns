import java.util.ArrayList;
import java.util.Comparator;

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

		System.out.println("--- Demo: sort a list with a comparator ---");
		System.out.println();

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

		// versions.sort() // oops! need a comparator

		VersionComparator vcomp = new VersionComparator();
		versions.sort(vcomp);

		System.out.print("Sorted versions: ");
		System.out.println(versions);

		ReverseComparator<VersionData> rvcomp = new ReverseComparator<>(vcomp);

		versions.sort(rvcomp);

		System.out.print("Reversed versions: ");
		System.out.println(versions);



		System.out.println();
		System.out.println("--- Demo: use a comparator to enhance flexibility ---");
		System.out.println();

		// call printOrderInfo with a comparator
		printOrderInfo(new VersionData("1.0.0"), new VersionData("1.5.2"), new VersionComparator());

		// call printOrderInfo without a comparator, implicitly using the
		// Comparable implementation ("the natural ordering")
		printOrderInfo(200, 100);
		printOrderInfo("ABC", "XYZ");

	}

	private static <T extends Comparable<? super T>> void printOrderInfo(T o1, T o2) {
		// Comparator.naturalOrder() returns a Comparator that simply calls the
		// compare() function.
		printOrderInfo(o1, o2, Comparator.naturalOrder());
	}

	private static <T> void printOrderInfo(T o1, T o2, Comparator<? super T> comparator) {
		int cmp = comparator.compare(o1, o2);
		if (cmp < 0) {
			System.out.println(String.format("%s < %s", o1.toString(), o2.toString()));
		} else if (cmp > 0) {
			System.out.println(String.format("%s > %s", o1.toString(), o2.toString()));
		} else {
			System.out.println(String.format("%s == %s", o1.toString(), o2.toString()));
		}
	}

}
