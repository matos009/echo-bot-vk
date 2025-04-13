package com.videohosting.echobot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videohosting.echobot.clientW.VkClient;
import com.videohosting.echobot.enums.VkM;
import com.videohosting.echobot.model.VkEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class EchoBotService {

    private final ObjectMapper objectMapper;
    private final VkClient vkClient;
    private final String confirmationCode;
    private final String secret;

    public EchoBotService(ObjectMapper objectMapper, VkClient vkClient,
                          @Value("${vk.confirmation-code}") String confirmationCode,
                          @Value("${vk.secret}") String secret) {
        this.objectMapper = objectMapper;
        this.vkClient = vkClient;
        this.confirmationCode = confirmationCode;
        this.secret = secret;
    }

    public String handleEvent(String payload) {
        try {
            VkEvent event = objectMapper.readValue(payload, VkEvent.class);

            if (VkM.CONFIRMATION.getMethod().equals(event.getType())) {
                return confirmationCode;
            }

            if (!secret.equals(event.getSecret())) {
                return "not allowed";
            }

            if (VkM.SENDMESSAGE.getMethod().equals(event.getType())) {
                Long userId = event.getObject().getMessage().getFrom_id();
                String text = event.getObject().getMessage().getText();


                System.out.println("Получено сообщение от " + userId + ": " + text);

                vkClient.sendRequest(userId, text);
                return "ok";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}