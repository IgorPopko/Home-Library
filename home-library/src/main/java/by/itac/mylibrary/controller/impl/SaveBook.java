package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class SaveBook implements Command {

	@Override
	public String execute(String request) {
		String response;
		char delim = ' ';
		String[] dataBook = request.split(String.valueOf(delim));
		int id = 1;
		int author = 2;
		int title = 3;
		int yearOfPublishing = 4;
		int status = 5;
		
		Book book = new Book(Integer.parseInt(dataBook[id]), dataBook[author], dataBook[title],
				Integer.parseInt(dataBook[yearOfPublishing]), dataBook[status]);
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		BookService bookService = serviceProvider.getBookService();
		
		try {
			bookService.save(book);
			response = "successful book save";
		} catch (ServiceException e) {

			response = "write error";
		}
		return response;
	}

}
