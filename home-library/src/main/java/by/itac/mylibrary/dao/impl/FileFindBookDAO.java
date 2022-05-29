package by.itac.mylibrary.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {
	private final LibraryList libraryList = LibraryList.getInstance();
	private List<Book> library;

	@Override
	public Book findByID(int id) throws DAOException {
		try {
			library = libraryList.getLibrary();
		} catch (IOException e) {
			throw new DAOException(e);
		}
		for (Book book : library) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> findByTitle(String title) throws DAOException {
		List<Book> book = new ArrayList<>();
		try {
			library = libraryList.getLibrary();
		} catch (IOException e) {
			throw new DAOException(e);
		}

		for (Book b : library) {
			if (b.getTitle().equals(title)) {
				book.add(b);
			}
		}
		return book;

	}

	@Override
	public List<Book> findByAuthor(String author) throws DAOException {
		List<Book> book = new ArrayList<>();
		try {
			library = libraryList.getLibrary();
		} catch (IOException e) {
			throw new DAOException(e);
		}

		for (Book b : library) {
			if (b.getAuthor().equals(author)) {
				book.add(b);
			}
		}
		return book;
	}

}
