package by.itac.mylibrary.controller;

import by.itac.mylibrary.controller.command.Command;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final char delim = ' ';

	public String executeTask(String request) {
		String commandName;
		Command executionCommand;

		commandName = request.substring(0, request.indexOf(delim));
		executionCommand = provider.getCommand(commandName.toUpperCase());

		String response = null;
		response = executionCommand.execute(request);

		return response;
	}
}
