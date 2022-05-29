package by.itac.mylibrary.start;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) throws DAOException, ServiceException {
		Controller start = new Controller();
		System.out.println(start.executeTask("SAVE_BOOK 72 aara bbbr 1801 ccrc"));
		System.out.println(start.executeTask("FIND_BOOK_BY_ID 4"));
		System.out.println(start.executeTask("FIND_BOOK_BY_TITLE Властелин кольца"));
		System.out.println(start.executeTask("FIND_BOOK_BY_AUTHOR Скотт Линч"));

	}
}
