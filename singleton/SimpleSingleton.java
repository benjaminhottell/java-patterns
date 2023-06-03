public class SimpleSingleton {

	private static SimpleSingleton instance = new SimpleSingleton();

	private SimpleSingleton() {
		System.out.println("SimpleSingleton: constructor");
	}

	public void doSomething() {
		System.out.println("SimpleSingleton: doSomething");
	}

	// for demo purposes, don't write code like this
	public static void doNothing() {}

	public static SimpleSingleton getInstance() {
		return instance;
	}

}
