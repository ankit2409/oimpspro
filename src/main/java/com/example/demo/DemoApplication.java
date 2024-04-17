package com.example.demo;

import com.example.demo.mqtt.MqttSubscriber;
import com.example.demo.mqtt.NewMqttSubscriber;
import com.example.demo.services.McuMessageService;
import com.example.demo.services.NodeMcuService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {

	@GetMapping("pmp")
	public String mapping() {
		return "Hello PMP";
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
