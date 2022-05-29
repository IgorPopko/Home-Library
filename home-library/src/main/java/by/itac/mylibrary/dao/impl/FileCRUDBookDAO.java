package by.itac.mylibrary.dao.impl;

import java.io.IOException;
import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {
	private final LibraryList libraryList = LibraryList.getInstance();
	private List<Book> library;

	@Override
	public void save(Book book) throws DAOException {
		try {
			library = libraryList.getLibrary();
			library.add(book);
			libraryList.updateFile(book);
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void delete(Book book) throws DAOException {
		try {
			library = libraryList.getLibrary();
			library.remove(book);
			libraryList.writeToFile();
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		try {
			library = libraryList.getLibrary();
			for (Book b : library) {
				if (b.getId() == id) {
					library.remove(b);
				}
			}
			libraryList.writeToFile();
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

}
