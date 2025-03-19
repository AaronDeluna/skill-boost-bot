package org.javaacademy.skillboostbot.service.command;

import lombok.RequiredArgsConstructor;
import org.javaacademy.skillboostbot.service.MessageService;
import org.springframework.stereotype.Service;

import static org.javaacademy.skillboostbot.service.MessageBot.HELP_COMMAND_MESSAGE;

@Service
@RequiredArgsConstructor
public class HelpCommandService {
    private final MessageService messageService;

    public void sendHelpCommand(Long chatId) {
        messageService.sendMessage(chatId, HELP_COMMAND_MESSAGE.getName());
    }
}
