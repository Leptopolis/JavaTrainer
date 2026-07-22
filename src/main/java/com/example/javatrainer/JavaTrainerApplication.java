package com.example.javatrainer;

import com.example.javatrainer.bot.JavaTrainerBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JavaTrainerApplication {

    public static void main(String[] args) {
		System.setProperty("https.proxyHost", "cluster-node1.mosline.ru");
		System.setProperty("https.proxyPort", "443");
		System.out.println("HTTP proxy host: " + System.getProperty("http.proxyHost"));
System.out.println("HTTP proxy port: " + System.getProperty("http.proxyPort"));
System.out.println("HTTPS proxy host: " + System.getProperty("https.proxyHost"));
System.out.println("HTTPS proxy port: " + System.getProperty("https.proxyPort"));
System.out.println("proxy set: " + System.getProperty("java.net.useSystemProxies"));
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.out.println("preferIPv4Stack = " + System.getProperty("java.net.preferIPv4Stack"));
        // 1. Запускаем Spring Boot приложение
        ConfigurableApplicationContext context = SpringApplication.run(JavaTrainerApplication.class, args);

        // 2. Получаем бин нашего бота из контекста Spring
        JavaTrainerBot bot = context.getBean(JavaTrainerBot.class);

        // 3. Регистрируем бота в Telegram API
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
            System.out.println("✅ Бот успешно запущен!");
        } catch (TelegramApiException e) {
            System.err.println("❌ Ошибка регистрации бота: " + e.getMessage());
            e.printStackTrace();
        }
    }
}