package com.example.telegbotonwhook.bots;


import com.pengrad.telegrambot.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WHookBot {

    TelegramBot bot = new TelegramBot("6534879689:AAG3w5c8yI-ROGBoKk7BSw1WvEWxo3XExV8");



}
