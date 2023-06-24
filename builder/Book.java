import java.util.Objects;

public class Book {

	private final String name;
	private final String author;
	private final String color;
	private final int publishYear;

	public Book(
			String name,
			String author,
			String color,
			int publishYear) {
		this.name = Objects.requireNonNull(name, "name");
		this.author = author;
		this.color = color;
		this.publishYear = publishYear;
	}

	public String getName() { return this.name; }
	public String getAuthor() { return this.author; }
	public String getColor() { return this.color; }
	public int getPublishYear() { return this.publishYear; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Book titled '")
			.append(this.name)
			.append("'");


		if (this.author != null) {
			sb.append(" written by ")
				.append(this.author);
		}

		if (this.publishYear > 0) {
			sb.append(" published ")
				.append(this.publishYear);
		}

		if (this.color != null) {
			sb.append(" (")
				.append(this.color)
				.append(" cover)");
		}

		sb.append('.');

		return sb.toString();
	}

}
