package ru.chernogrivov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chernogrivov.config.TelegramBotConfig;
import ru.chernogrivov.controller.TelegramBot;

@SpringBootApplication
public class DispatcherApplication {
    public static void main(String[] args) {
        SpringApplication.run(DispatcherApplication.class);

    }
}