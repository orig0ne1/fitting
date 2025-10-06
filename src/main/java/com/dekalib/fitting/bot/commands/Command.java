package com.dekalib.fitting.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    String commandName();
    void handle(Update update);
}
