package org.javaacademy.skillboostbot.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotCommand {
    START("/start"),
    COMMAND_HELP("/commandHelp"),
    ;

    private final String name;
}
