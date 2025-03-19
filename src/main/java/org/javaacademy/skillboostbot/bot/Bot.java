package org.javaacademy.skillboostbot.bot;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.skillboostbot.service.BotCommandHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String username;
    private final BotCommandHandler botCommandHandler;

    public Bot(@Lazy BotCommandHandler botCommandHandler) {
        super();
        this.botCommandHandler = botCommandHandler;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        botCommandHandler.updateReceived(update);
    }
}
