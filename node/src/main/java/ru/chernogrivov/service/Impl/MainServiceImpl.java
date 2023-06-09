package ru.chernogrivov.service.Impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.chernogrivov.dao.RawDataDAO;
import ru.chernogrivov.entity.RawData;
import ru.chernogrivov.service.MainService;
import ru.chernogrivov.service.ProducerService;
@Service
public class MainServiceImpl implements MainService {

    private final RawDataDAO rawDataDAO;
    private final ProducerService producerService;

    public MainServiceImpl(RawDataDAO rawDataDAO, ProducerService producerService) {
        this.rawDataDAO = rawDataDAO;
        this.producerService = producerService;
    }




    @Override
    public void processTextMessage(Update update) {
    saveRawData(update);

        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from Node");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRawData(Update update) {
        RawData rawData= RawData.builder().event(update).build();
        rawDataDAO.save(rawData);
    }
}
