package com.company.bookseller.controller;

public class CommandFactory {
    public static CommandFactory getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        static final CommandFactory instance = new CommandFactory();
    }

    private CommandFactory() {
    }

    public Command getCommand(String action) {
        Command command = Commands.ERROR.get();
        if (action == null) {
            return command;
        }
        try {
            command = Commands.valueOf(action.toUpperCase()).get();
        } catch (IllegalArgumentException ignored) {
        }
        return command;
    }
}

