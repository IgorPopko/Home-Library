package by.itac.mylibrary.service;

import java.util.List;

import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;

public interface BookService {
	
	void save (Book book) throws ServiceException;
	Book findByID(int id) throws ServiceException;
	List<Book> findByTitle(String title) throws ServiceException;
	List<Book> findByAuthor(String author) throws ServiceException;

}
