package com.bajajfinserv.healthqualifier;

import com.bajajfinserv.healthqualifier.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HealthQualifierApplication {

    @Autowired
    private WebhookService webhookService;

    public static void main(String[] args) {
        SpringApplication.run(HealthQualifierApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("Application started successfully!");
        System.out.println("Starting webhook flow...");
        
        // Trigger the webhook flow on application startup
        webhookService.processWebhookFlow();
    }
}
