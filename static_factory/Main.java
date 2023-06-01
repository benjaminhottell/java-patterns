public class Main {

	public static void main(String[] args) {
		System.out.println(GeometryFactory.newPoint(1.0, 2.0));
		System.out.println(GeometryFactory.newPoint(1, 2));
		System.out.println(GeometryFactory.circleFromRadius(30));
		System.out.println(Circle.withRadius(50));
	}

}
