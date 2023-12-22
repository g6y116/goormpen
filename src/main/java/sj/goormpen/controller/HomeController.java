package sj.goormpen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import sj.goormpen.dto.Message;
import sj.goormpen.dto.Status;
import sj.goormpen.repository.UserRepository;

@RestController
public class HomeController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    UserRepository userRepository;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        if (message.getStatus() == Status.JOIN) {
            userRepository.addUser(message.getSenderName());
            System.out.println("현재 유저 수 : " + userRepository.getUsers().toString());
        }

        System.out.println(message.toString());
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private", message);

        System.out.println(message.toString());
        return message;
    }
}
