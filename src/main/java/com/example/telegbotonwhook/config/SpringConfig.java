package com.example.telegbotonwhook.config;


import com.example.telegbotonwhook.bots.WriteReadBot;
import com.example.telegbotonwhook.service.MessageHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;


@Configuration
@AllArgsConstructor
public class SpringConfig {

    private final TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebhookPath()).build();
    }

    @Bean
    public WriteReadBot springWebhookBot(SetWebhook setWebhook, MessageHandler messageHandler) {
        WriteReadBot bot = new WriteReadBot(setWebhook, messageHandler);

        bot.setBotPath(telegramConfig.getWebhookPath());
        bot.setBotUsername(telegramConfig.getBotName());
        bot.setBotToken(telegramConfig.getBotToken());

        bot.setTooBigVoiceText(telegramConfig.getTooBigVoiceText());
        bot.setIllegalMessageText(telegramConfig.getIllegalMessageText());
        bot.setWtfText(telegramConfig.getWtfText());

        return bot;
    }


}
