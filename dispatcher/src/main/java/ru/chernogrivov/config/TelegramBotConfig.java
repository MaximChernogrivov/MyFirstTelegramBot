package ru.chernogrivov.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.chernogrivov.controller.TelegramBot;

@Configuration
public class TelegramBotConfig {
    TelegramBot telegramBot;

    @Autowired
    public void setTelegramBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void registrationMyTelegramBot() {
        TelegramBotsApi telegramBotAPI;
        try {
            telegramBotAPI = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotAPI.registerBot(telegramBot);
            System.out.println("\n"+telegramBot.getBotUsername()+" -> успешно запущен");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
