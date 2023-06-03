public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton() {
		System.out.println("LazySingleton: constructor");
	}

	public void doSomething() {
		System.out.println("LazySingleton: doSomething");
	}

	// for demo purposes, don't write code like this
	public static void doNothing() {}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

}

