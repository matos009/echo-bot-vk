package com.videohosting.echobot.controller;

import com.videohosting.echobot.service.EchoBotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vk")
public class VkController {
    private final EchoBotService echoBotService;

    public VkController(EchoBotService echoBotService) {
        this.echoBotService = echoBotService;
    }


    @PostMapping
    public @ResponseBody  String handleEvent(@RequestBody String payload) {
        return echoBotService.handleEvent(payload);
    }
}
