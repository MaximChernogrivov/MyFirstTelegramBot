package ru.chernogrivov.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Log4j
@Component
@Scope("prototype")
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private UpdateController updateController;

    public TelegramBot(UpdateController updateController){
        this.updateController= updateController;
    }
    @PostConstruct
    public void init(){
        updateController.registerBot(this);
    }
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
    updateController.processUpdate(update);
    }

    public void sendAnswerMessage(SendMessage message){
        if(message != null){
            try{
                execute(message);
            } catch (TelegramApiException e) {
                log.error(e);
            }
        }
    }
}
