package by.itac.mylibrary.service.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	public void save(Book book) throws ServiceException {
		// 1 VALIDATION INPUT DATA

		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.save(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public Book findByID(int id) throws ServiceException {
		Book response;

		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			response = dao.findByID(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return response;
	}

	@Override
	public List<Book> findByTitle(String title) throws ServiceException {
		List<Book> response;

		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			response = dao.findByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return response;
	}

	@Override
	public List<Book> findByAuthor(String author) throws ServiceException {
		List<Book> response;

		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			response = dao.findByAuthor(author);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return response;
	}

}
