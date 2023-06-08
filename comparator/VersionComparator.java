import java.util.Comparator;

public class VersionComparator implements Comparator<VersionData> {

	@Override
	public int compare(VersionData o1, VersionData o2) {

		int cmp = o1.major - o2.major;
		if (cmp != 0) return cmp;

		cmp = o1.minor - o2.minor;
		if (cmp != 0) return cmp;

		return o1.patch - o2.patch;

	}

}
