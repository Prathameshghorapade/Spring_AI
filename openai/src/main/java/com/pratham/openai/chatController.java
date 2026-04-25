package com.pratham.openai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class chatController {

    private final ChatClient chatClient;

    public chatController(ChatClient.Builder chatclientBuilder){
        this.chatClient=chatclientBuilder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
        return chatClient.prompt(message).call().content();
    }
}
