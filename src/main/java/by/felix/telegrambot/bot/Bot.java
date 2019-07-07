package by.felix.telegrambot.bot;

import by.felix.telegrambot.database.entity.City;
import by.felix.telegrambot.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


public class Bot extends TelegramLongPollingBot {

    @Autowired
    private CityService cityService;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new Bot());
        }
        catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        City city = cityService.getByName(message);
        String response = city.getText();
        sendMsg(update.getMessage().getChatId().toString(), response);
    }

    @Override
    public String getBotUsername() {
        return "Simple_CIty_bot";
    }

    @Override
    public String getBotToken() {
        return "773542686:AAEzamulzXY8fSQEWAlfNR2DEqfILF6m6Xk";
    }


    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
