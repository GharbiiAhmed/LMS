package com.avaxia.lms.services;
import com.avaxia.lms.entities.Message;

import java.util.List;
public interface IMessageService {
    Message createMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(Long messageId);
    List<Message> getMessagesBetweenUsers(Long senderId, Long receiverId);
}
