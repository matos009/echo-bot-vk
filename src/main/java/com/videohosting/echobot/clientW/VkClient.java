package com.videohosting.echobot.clientW;

import com.videohosting.echobot.enums.Urls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VkClient {
    private RestTemplate restTemplate;
    private String token;

    public VkClient(@Value("${vk.token}") String token) {
        this.restTemplate = new RestTemplate();
        this.token = token;
    }

    public void sendRequest(Long userId, String message){
        String url = "https://api.vk.com/method/" +Urls.SEND_MESSAGE.getMethod() +
                "?user_id=" + userId +
                "&message=" + message +
                "&random_id=" + System.currentTimeMillis() +
                "&access_token=" + token +
                "&v=5.131";
        restTemplate.getForObject(url, String.class);
    }
}
