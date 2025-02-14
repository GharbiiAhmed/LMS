package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Message;
import com.avaxia.lms.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping
    public Message updateMessage(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/{senderId}/{receiverId}")
    public List<Message> getMessagesBetweenUsers(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return messageService.getMessagesBetweenUsers(senderId, receiverId);
    }
}