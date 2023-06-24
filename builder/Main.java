import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void demo1() {

		System.out.println("--- Demo: Construct a Book manually ---");

		// Here I invoke Book's constructor manually.

		// Concerns:
		//   1. What if Book's constructor is changed? What if its elements are reordered?
		//   2. How do I know if I put the arguments in the right order? Did I mix up author and title?
		Book b1 = new Book(
				"Head First Design Patterns",
				"Eric Freeman & Elisabeth Robson",
				"white",
				2004);

		System.out.println(b1);

		// Here I invoke the constructor again.
		// New concern: We have to explicitly include obscure 'null' placeholder values.
		Book b2 = new Book(
				"Obscure Book",
				null,
				null,
				-1);

		System.out.println(b2);

	}

	public static void demo2() {

		System.out.println("--- Demo: Use a builder instead ---");

		// Advantages:
		//   1. Very obvious which field is which (more readable)
		//   2. Fields can go in any order (no risk of mixing them up)
		//   3. Book's constructors can evolve independently
		// Disadvantages:
		//   1. Introducing a new intermediate object, BookBuilder
		//   2. More typing
		Book b1 = new BookBuilder()
			.setName("Head First Design Patterns")
			.setAuthor("Eric Freeman & Elisabeth Robson")
			.setPublishYear(2004)
			.setColor("white")
			.build();

		System.out.println(b1);

		// Additional advantage: placeholder/empty values can be implicitly left out.
		Book b2 = new BookBuilder()
			.setName("Obscure Book")
			.build();

		System.out.println(b2);

	}

	public static void main(String[] args) {
		demo1();
		demo2();
	}
}
