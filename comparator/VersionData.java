public class VersionData {

	public int major;
	public int minor;
	public int patch;

	public VersionData(int major, int minor, int patch) {
		this.major = major;
		this.minor = minor;
		this.patch = patch;
	}

	public VersionData(String s) {
		String[] parts = s.split("[.]");
		this.major = Integer.parseInt(parts[0]);
		this.minor = Integer.parseInt(parts[1]);
		this.patch = Integer.parseInt(parts[2]);
	}

	@Override
	public String toString() {
		return String.format("%d.%d.%d", major, minor, patch);
	}

}
