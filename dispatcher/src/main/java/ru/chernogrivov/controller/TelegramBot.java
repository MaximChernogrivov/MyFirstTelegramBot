package ru.chernogrivov.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Log4j
@Component
@Scope("prototype")
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public TelegramBot(){}
    @Override
    public String getBotUsername() {
        return this.username;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
    var originalMessage= update.getMessage();
        log.debug(originalMessage.getText());
    }
}
