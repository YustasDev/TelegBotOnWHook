package com.example.telegbotonwhook.service;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MessageHandler {

    Converter converter;
    TelegramApiClient telegramApiClient;
    String tempFileNamePrefix;

    public MessageHandler(Converter converter,
                          TelegramApiClient telegramApiClient,
                          @Value("${files.outgoing}") String tempFileNamePrefix) {
        this.converter = converter;
        this.telegramApiClient = telegramApiClient;
        this.tempFileNamePrefix = tempFileNamePrefix;
    }

    public BotApiMethod<?> answerMessage(Message message) throws IOException {
        if (message.hasVoice()) {
            convertVoice(message);
        } else if (message.getText() != null && message.getText().equals("/start")) {
            telegramApiClient.uploadStartPhoto(message.getChatId().toString());
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }

    private void convertVoice(Message message) throws IOException {
        Voice voice = message.getVoice();

        if (voice.getDuration() > 600) {
            throw new TooBigVoiceMessageException();
        }

        File source = telegramApiClient.getVoiceFile(voice.getFileId());
        File target = File.createTempFile(this.tempFileNamePrefix, ".mp3");

        try {
            converter.convertOggToMp3(source.getAbsolutePath(), target.getAbsolutePath());
        } catch (Exception e) {
            throw new IOException();
        }

        telegramApiClient.uploadAudio(message.getChatId().toString(),
                new ByteArrayResource(Files.readAllBytes(target.toPath())) {
                    @Override
                    public String getFilename() {
                        return "IlııIIIıııIııııııIIIIllıııııIıııııı.mp3";
                    }
                }
        );
    }

}
