package com.example.demo.controller;

import com.example.demo.model.MCUMessage;
import com.example.demo.services.McuMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MCUMessageController {

    @Autowired
    McuMessageService mcuMessageService;

    @PostMapping("/addMcuMessage")
    public String addMcuMessage() {
        MCUMessage mcuMessage = new MCUMessage();
        mcuMessage.setDeviceId("nodemcu");
        mcuMessage.setSiteId("SH-01");
        mcuMessage.setCount(5600);
        mcuMessage.setPublishedTime(new Date());
        LoggerFactory.getLogger(MCUMessageController.class).info("saving mcu message to database");
        mcuMessageService.addMcuMessage(mcuMessage);
        return "add-mcu-message";
    }
}
