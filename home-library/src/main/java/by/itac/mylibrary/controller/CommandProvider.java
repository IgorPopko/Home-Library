package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.impl.FindBookByID;
import by.itac.mylibrary.controller.impl.FindBookByTitle;
import by.itac.mylibrary.controller.impl.FindBookByAuthor;
import by.itac.mylibrary.controller.impl.SaveBook;
import by.itac.mylibrary.controller.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SAVE_BOOK, new SaveBook());
        repository.put(CommandName.FIND_BOOK_BY_ID, new FindBookByID());
        repository.put(CommandName.FIND_BOOK_BY_TITLE, new FindBookByTitle());
        repository.put(CommandName.FIND_BOOK_BY_AUTHOR, new FindBookByAuthor());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
