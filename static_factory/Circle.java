public class Circle {

	public double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getCircumference() {
		return 2.0 * Math.PI * this.radius;
	}

	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public String toString() {
		return String.format("Circule(radius=%f)", this.radius);
	}

	// We can embed static construction methods inside of the class itself, as
	// an alternative to creating a standalone static factory. While these
	// static construction methods are redundant with the constructor, they
	// make the functionality obvious to readers who may not know (or remember)
	// whether Circle's constructor takes a radius or a diameter.

	public static Circle withRadius(double r) {
		return new Circle(r);
	}

	public static Circle withDiameter(double d) {
		return new Circle(d / 2.0);
	}

}


