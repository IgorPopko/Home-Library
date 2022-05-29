package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.entity.Book;

public class LibraryList {
	private static LibraryList instance = null;

	private final List<Book> library = new ArrayList<>();
	private final String delim = "__";
	private boolean status = false;
	private final static String PATH = "E:\\Workspace\\home-library\\src\\main\\resources\\Home-Library.txt";

	private LibraryList() {
	}

	public static LibraryList getInstance() {
		if (instance == null) {
			instance = new LibraryList();
		}
		return instance;

	}

	public List<Book> getLibrary() throws IOException {
		if (!status) {
			readFile();
			status = true;
		}
		return library;
	}

	private void readFile() throws IOException {
		int id = 0;
		int author = 1;
		int title = 2;
		int yearOfPublishing = 3;
		int status = 4;
		try (BufferedReader buffer = new BufferedReader(new FileReader(PATH))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				String[] dateBook = line.split(delim);
				library.add(new Book(Integer.parseInt(dateBook[id]), dateBook[author], dateBook[title],
						Integer.parseInt(dateBook[yearOfPublishing]), dateBook[status]));
			}
		}
	}

	public void writeToFile() throws IOException {
		try (FileWriter writer = new FileWriter(PATH)) {
			for (Book book : library) {
				StringBuilder text = new StringBuilder();
				text.append(book.getId()).append(delim).append(book.getAuthor()).append(delim).append(book.getTitle())
						.append(delim).append(book.getYearOfPublishing()).append(delim).append(book.getStatus())
						.append(delim).append("\n");
				writer.write(text.toString());
			}
		}
	}

	public void updateFile(Book book) throws IOException {
		try (FileWriter writer = new FileWriter(PATH, true)) {
			StringBuilder dateToWrite = new StringBuilder();
			dateToWrite.append(book.getId()).append(delim).append(book.getAuthor()).append(delim)
					.append(book.getTitle()).append(delim).append(book.getYearOfPublishing()).append(delim)
					.append(book.getStatus()).append(delim).append("\n");
			writer.write(dateToWrite.toString());

		}
	}
}
