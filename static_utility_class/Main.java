public class Main {

	public static void main(String[] args) {

		System.out.println("--- Intercept stdout demo ---");
		StdoutInterceptor.startDiscarding();
		System.out.println("Discarded");
		StdoutInterceptor.stopIntercepting();
		System.out.println("Not discarded");

		System.out.println("--- Math demo ---");
		System.out.println("Sin(90 deg) = " + Math.sin(Math.toRadians(90.0)));
		System.out.println("Cos(90 deg) = " + Math.cos(Math.toRadians(90.0)));

	}

}
