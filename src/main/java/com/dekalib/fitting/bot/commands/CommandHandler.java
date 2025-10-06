package com.dekalib.fitting.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private Map<String, Command> list = new HashMap<>();

    public void registerCommands(Command... commands) {
        for(Command command : commands) {
            list.put(command.commandName(), command);
        }
    }

    public void handle(String commandName, Update update) {
        Command command = list.get(commandName);
        command.handle(update);
    }
}
