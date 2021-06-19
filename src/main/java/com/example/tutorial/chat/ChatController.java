package com.example.tutorial.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatService chatService;

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/getAll")
    public List<Chat> showDiscussion() {

        return chatService.getAllChats();
    }

    @GetMapping("/getAllByDate/{date}")
    public List<Chat> getDiscussionsByDate(@PathVariable int date) {
        return chatService.getByDate(date);
    }

    @PostMapping("/addMessage")
    public Chat addDiscussion(@RequestBody Chat discussion) {
        return chatService.addMessage(discussion);
    }
}
