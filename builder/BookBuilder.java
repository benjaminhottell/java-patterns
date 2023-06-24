public class BookBuilder {

	private String name = null;
	private String author = null;
	private String color = null;
	private int publishYear = -1;

	public BookBuilder() {
	}

	public BookBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BookBuilder setColor(String color) {
		this.color = color;
		return this;
	}

	public BookBuilder setPublishYear(int year) {
		this.publishYear = publishYear;
		return this;
	}

	public Book build() {
		return new Book(
			this.name,
			this.author,
			this.color,
			this.publishYear);
	}

}
