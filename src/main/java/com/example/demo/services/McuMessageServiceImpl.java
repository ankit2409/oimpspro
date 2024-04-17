package com.example.demo.services;

import com.example.demo.model.MCUMessage;
import com.example.demo.model.NodeMcu;
import com.example.demo.repository.McuMessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class McuMessageServiceImpl implements McuMessageService{
    Logger logger = LoggerFactory.getLogger(McuMessageServiceImpl.class);
    @Autowired
    McuMessageRepository mcuMessageRepository;

    @Autowired
    NodeMcuService nodeMcuService;
    ObjectMapper mapper = new ObjectMapper();


    @Override
    public MCUMessage addMcuMessage(MCUMessage mcuMessage) {
        try{
        logger.info("saving mcu message to database "+mcuMessage.toString());
        mcuMessageRepository.save(mcuMessage);
        logger.info("mcu message added");}
        catch(Exception e){
            logger.error("error adding mcu message to database"+e);
        }
        return mcuMessage;
    }


    @Override
    public void sendMcuMessage(String message) throws JsonProcessingException {
        MCUMessage mcuMessage = mapper.readValue(message, MCUMessage.class);
        if(mcuMessage.getSiteId().equals("HDR-02")){
            mcuMessage.setNodeMcuCode("NODEMCU_CODE_HDR02");
        }
        else if(mcuMessage.getSiteId().equals("BF-02")){
            mcuMessage.setNodeMcuCode("NODEMCU_CODE_BF02");
        }
        else if(mcuMessage.getSiteId().equals("BF-06")){
            mcuMessage.setNodeMcuCode("NODEMCU_CODE_BF06");
        }else {
            mcuMessage.setNodeMcuCode("NODEMCU_CODE_1");
        }
        logger.info("received mcu message from mqtt "+mcuMessage.toString());
        String nodeMcuCode = mcuMessage.getNodeMcuCode();
        if(nodeMcuCode == null){
            NodeMcu nodeMcu = new NodeMcu();
            nodeMcu.setCode("NODEMCU_CODE_1");
            nodeMcu.setName("MCU_NAME_1");
            nodeMcu.setReceivedTime(new Date());
            nodeMcu.setStatus("active");
            nodeMcu.setInstallationDate(new Date());
            logger.info("NodeMcu not found in database, adding new nodeMcu {}",nodeMcu.toString());
            nodeMcuService.addNodeMcu(nodeMcu);
        }

        addMcuMessage(mcuMessage);
    }
}
