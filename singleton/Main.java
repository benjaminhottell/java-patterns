public class Main {

	public static void main(String[] args) {

		// I call doNothing up here to show that the SimpleSingleton is
		// constructed when the class is loaded, while the LazySingleton isn't.
		// Although these calls seem like they do nothing, they really cause
		// the class to be loaded, and the static variables to be initialized.
		SimpleSingleton.doNothing();
		LazySingleton.doNothing();

		System.out.println("--- Simple singleton demo ---");
		SimpleSingleton.getInstance().doSomething();
		SimpleSingleton.getInstance().doSomething();

		System.out.println("--- Lazy singleton demo ---");
		LazySingleton.getInstance().doSomething();
		LazySingleton.getInstance().doSomething();

	}

}
