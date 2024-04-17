package com.example.demo.mqtt;

import com.example.demo.model.MCUMessage;
import com.example.demo.model.NodeMcu;
import com.example.demo.services.McuMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NewMqttSubscriber {

    Logger logger = LoggerFactory.getLogger(NewMqttSubscriber.class);

//    @Value(value = "${mqtt.broker-url}")
    private String brokerUrl = "ssl://d08900cfdef5463098201f44a1532917.s2.eu.hivemq.cloud:8883";

//    @Value(value = "${mqtt.client-id}")
    private String clientId = "MQTT_FX_Client";

//    @Value(value = "${mqtt.default-topic}")
    private String defaultTopic = "esp8266_data_BF02,esp8266_data_BF06,esp8266_data_HDR-02";

    private String userName = "ankit";

    private String password = "Ankit@123";

    @Autowired
    private Channel channel;
    @Autowired
    McuMessageService mcuMessageService;


    @Bean
    public DefaultMqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getConnectionInfo());
        logger.info("Factory created");
        return factory;
    }



    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttInbound(DefaultMqttPahoClientFactory mqttClientFactory) {
        String[] topics = defaultTopic.split(",");
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId + "_inbound", mqttClientFactory, topics);
        adapter.setCompletionTimeout(5000); // Set timeout (milliseconds) for message processing
        adapter.setConverter(new DefaultPahoMessageConverter()); // Optional: Customize message converter
        adapter.setQos(1); // Set Quality of Service (QoS)
        adapter.setOutputChannel(channel.mqttInputChannel());
        logger.info("Adapter created {} {}",adapter.getConnectionInfo());
        return adapter;
    }

    public MqttConnectOptions getConnectionInfo() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setServerURIs(new String[] {brokerUrl});
        return options;
    }
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(String message) throws JsonProcessingException {

//        logger.info("Received message: " + message);
        System.out.println("Received message: " + message);
        mcuMessageService.sendMcuMessage(message);

        // Process the received message as needed
    }
}
@Configuration
class Channel{
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }
}
