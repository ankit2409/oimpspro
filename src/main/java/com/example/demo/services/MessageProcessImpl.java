package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageProcessImpl implements MessageProcess {
    public void execute(List<String> list) {
        System.out.println("MessageProcessImpl.execute");
    }
}
