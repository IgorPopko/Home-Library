package by.itac.mylibrary.entity;

import java.util.Objects;

public class Book {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private int yearOfPublishing;
	 private String status;

	public Book(int id, String author, String title, int yearOfPublishing, String status) {
		this.id = id;
		this.author = author;
		this.title = title;		
		this.yearOfPublishing = yearOfPublishing;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, author, title, yearOfPublishing, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title) && yearOfPublishing == other.yearOfPublishing;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearOfPublishing=" + yearOfPublishing
				+ ", status=" + status + "]";
	}

	
}
