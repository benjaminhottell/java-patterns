public class DoublePoint {

	public double x;
	public double y;

	public DoublePoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public DoublePoint() {
		this(0.0, 0.0);
	}

	@Override
	public String toString() {
		return String.format("DoublePoint(x=%f, y=%f)", x, y);
	}

}

