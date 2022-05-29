package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByID implements Command{
	private final char delim = ' ';

	@Override
	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			int id = Integer.parseInt(request.substring(request.indexOf(delim) + 1));
			Book book = bookService.findByID(id);
			if (book == null) {
				response = "A book with this ID is not in the library";
			} else {
			response = book.toString();
			}
		} catch (ServiceException e) {
			response = "id search error";
		}
		
		return response;
	}
	

}
