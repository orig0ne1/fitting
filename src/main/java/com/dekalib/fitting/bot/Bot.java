package com.dekalib.fitting.bot;

import com.dekalib.fitting.bot.commands.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {
    public final CommandHandler handler = new CommandHandler();
    public final BotConfig botConfig;

    @Autowired
    public Bot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            handler.handle(text, update);
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}
