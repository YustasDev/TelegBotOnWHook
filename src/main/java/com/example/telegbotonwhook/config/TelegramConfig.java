package com.example.telegbotonwhook.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TelegramConfig {

    @Value("${telegram.webhook-path}")
    String webhookPath;
    @Value("${telegram.bot-name}")
    String botName;
    @Value("${telegram.bot-token}")
    String botToken;
    @Value("${message.too-big-voice.text}")
    String tooBigVoiceText;
    @Value("${message.illegal-message.text}")
    String illegalMessageText;
    @Value("${message.wtf.text}")
    String wtfText;

}
