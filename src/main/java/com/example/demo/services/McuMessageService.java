package com.example.demo.services;

import com.example.demo.model.MCUMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public interface McuMessageService {

    MCUMessage addMcuMessage(MCUMessage mcuMessage);

    void sendMcuMessage(String message) throws JsonProcessingException;
}
