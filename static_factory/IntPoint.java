public class IntPoint {

	public int x;
	public int y;

	public IntPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public IntPoint() {
		this(0, 0);
	}

	@Override
	public String toString() {
		return String.format("IntPoint(x=%d, y=%d)", x, y);
	}

}
