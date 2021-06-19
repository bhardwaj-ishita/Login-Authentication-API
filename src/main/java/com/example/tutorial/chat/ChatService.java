package com.example.tutorial.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    ChatRepository chatRepository;

    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public List<Chat> getByDate(int date)
    {
        return chatRepository.findByDate(LocalDate.of(2021, 6,date));
    }

    public Chat addMessage(Chat discussion) {
        log.info("I'm here too");
        return chatRepository.save(discussion);
    }
}
