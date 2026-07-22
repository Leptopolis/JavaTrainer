package com.example.javatrainer.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class JavaTrainerBot extends TelegramLongPollingBot{
    @Override
    public String getBotUsername(){
        return "LeptoppolisTrainerBot";
    }

    @Override
    public String getBotToken(){
        return "8532252151:AAHEvCiQuNVOkJ1p7Tq11IajSotMpl8d768";
    }

    @Override
    public void onUpdateReceived(Update update){
        try {
            System.out.println("Получено обновление: " + update);
            if(update.hasMessage() && update.getMessage().hasText()){
                String text = update.getMessage().getText();
                String chatId = update.getMessage().getChatId().toString();

                if(text.equals("/start")){
                    send(chatId, "I'm bot");
                }

            }
        } catch (Exception e) {
            System.err.println("Ошибка при обработке обновления: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void send(String chatId, String text){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try{
            execute(message);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }
}