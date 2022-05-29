package by.itac.mylibrary.controller.impl;

import java.util.List;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByTitle implements Command {
	private final char delim = ' ';

	@Override
	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();

		String response = null;

		try {
			String title = request.substring(request.indexOf(delim) + 1);;
			List<Book> book = bookService.findByTitle(title);
			if (book.isEmpty()) {
				response = "A book with this title is not in the library";
			} else {
				for (Book b : book) {
					response = response + b.toString() + '\n';
				}
			}
		} catch (ServiceException e) {
			response = "title search error";
		}

		return response;

	}

}
