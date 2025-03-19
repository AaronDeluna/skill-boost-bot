package org.javaacademy.skillboostbot.service.command;

import lombok.RequiredArgsConstructor;
import org.javaacademy.skillboostbot.service.MessageService;
import org.springframework.stereotype.Service;

import static org.javaacademy.skillboostbot.service.MessageBot.START_MESSAGE;

@Service
@RequiredArgsConstructor
public class StartCommandService {
    private final MessageService messageService;

    public void sendStartMenu(Long chatId) {
        messageService.sendMessage(chatId, START_MESSAGE.getName());
    }
}
