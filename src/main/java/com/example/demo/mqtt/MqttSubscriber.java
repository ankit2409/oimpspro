package com.example.demo.mqtt;
import com.example.demo.model.MCUMessage;
import com.example.demo.model.NodeMcu;
import com.example.demo.services.McuMessageService;
import com.example.demo.services.NodeMcuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import org.springframework.stereotype.Component;
import java.util.Date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MqttSubscriber implements Runnable{

    NodeMcuService nodeMcuService;

    McuMessageService mcuMessageService;
    public MqttSubscriber() {

    }

    @Autowired
    public MqttSubscriber(NodeMcuService nodeMcuService, McuMessageService mcuMessageService) {
        this.nodeMcuService = nodeMcuService;
        this.mcuMessageService = mcuMessageService;
    }

//    @PostConstruct
    public void run() {
        Logger logger = LoggerFactory.getLogger(MqttSubscriber.class);
        String broker = "ssl://d08900cfdef5463098201f44a1532917.s2.eu.hivemq.cloud:8883";
//        String broker = "tcp://192.168.1.5:1883"; // Replace with your MQTT broker's address
        String clientId = "MQTT_FX_Client";
        String topic = "esp8266_data_BF06"; // Replace with the MQTT topic you want to subscribe to
        String userName = "ankit";
        String password = "Ankit@123";
        ObjectMapper mapper = new ObjectMapper();

        try {
            MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();

            connOpts.setUserName(userName);
            connOpts.setPassword(password.toCharArray());
            connOpts.setCleanSession(false);
            connOpts.setKeepAliveInterval(60);

            logger.info("Connecting to broker: " + broker);
            client.connect(connOpts);

            logger.info("Connected");
            client.subscribe(topic);

            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost "+cause);
                }


                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {

                    logger.info("Received message on topic: " + topic);
//                    logger.info("Message: " + message);
                    byte[] payload = message.getPayload();
                    String jsonString = new String(payload);
//                    logger.info("jsonString: " + jsonString);

                    MCUMessage mcuMessage = mapper.readValue(jsonString, MCUMessage.class);

                    logger.info("MCUMessage: " + mcuMessage.toString());
                    mcuMessageService.addMcuMessage(mcuMessage);
//                    Instant instant = Instant.ofEpochSecond(mcuMessage.getPublishedTime());
                    ZoneOffset istOffset = ZoneOffset.of("+05:30");
//                    LocalDateTime istDateTime = LocalDateTime.ofInstant(instant, istOffset);
//                    logger.info("MCUMessage: {} time is {}" , mcuMessage.toString(),istDateTime);
                    NodeMcu nodeMcu = new NodeMcu();
//                    nodeMcu.setCount(mcuMessage.getCount());
                    nodeMcu.setCode(mcuMessage.getSiteId());
                    nodeMcu.setName("ankit");
//                    Date date = new Date(instant.toEpochMilli());
//                    nodeMcu.setReceivedTime(date);
                    nodeMcu.setStatus("active");
//                    nodeMcu.setCurrentTime(new Date());
                    logger.info("Nodemcu: {} " , nodeMcu.toString());
                    nodeMcuService.addNodeMcu(nodeMcu);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not used for subscribing
                }
            });

            logger.info("Subscribing to topic: " + topic);
            client.subscribe(topic);

            // Wait for messages
            while (true) {
                // Add your custom logic or sleep to keep the program running
                Thread.sleep(10);
            }

        } catch (MqttException me) {
            me.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

