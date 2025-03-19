package org.javaacademy.skillboostbot.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.skillboostbot.bot.Bot;
import org.javaacademy.skillboostbot.service.command.HelpCommandService;
import org.javaacademy.skillboostbot.service.command.StartCommandService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.javaacademy.skillboostbot.service.MessageBot.UNKNOWN_COMMAND_MESSAGE;

@Component
@RequiredArgsConstructor
public class BotCommandHandler {
    private final MessageService messageService;
    private final StartCommandService startCommandService;
    private final HelpCommandService helpCommandService;

    public void updateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        String message = update.getMessage().getText();
        checkCommand(chatId, message);
    }

    private void checkCommand(Long chatId, String message) {
        switch (message) {
            case "/start" -> startCommandService.sendStartMenu(chatId);
            case "/help" -> helpCommandService.sendHelpCommand(chatId);
            default -> sendUnknownCommandMessage(chatId);
        }
    }

    private void sendUnknownCommandMessage(Long chatId) {
        messageService.sendMessage(chatId, UNKNOWN_COMMAND_MESSAGE.getName());
    }
}
