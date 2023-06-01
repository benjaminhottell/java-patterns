public class GeometryFactory {

	private GeometryFactory() {
	}

	// While this function is technically redundant with Circle's constructor,
	// it is more readable and 'obvious' to someone who isn't familiar with
	// Circle's constructor(s). Readers don't have to guess whether the
	// parameter in the constructor is the radius or the diameter when they can
	// read the name of this function.

	public static Circle circleFromRadius(double r) {
		return new Circle(r);
	}

	public static Circle circleFromDiameter(double d) {
		return circleFromRadius(d / 2.0);
	}

	// We can also provide a common method for constructing otherwise disparate
	// types. Now the user can just create a 'point' regardless of what data
	// type is being used on the backend of that point.

	public static DoublePoint newPoint(double x, double y) {
		return new DoublePoint(x, y);
	}

	public static IntPoint newPoint(int x, int y) {
		return new IntPoint(x, y);
	}

}
