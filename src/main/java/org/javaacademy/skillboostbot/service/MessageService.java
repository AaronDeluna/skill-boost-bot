package org.javaacademy.skillboostbot.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.skillboostbot.bot.Bot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class MessageService {
    private final Bot bot;

    public void sendMessage(Long chatId, String message) {
        try {
            bot.execute(buildMessage(chatId, message));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private SendMessage buildMessage(Long chatId, String message) {
        return SendMessage.builder()
                .text(message)
                .chatId(chatId.toString())
                .build();
    }
}
