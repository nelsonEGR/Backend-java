package com.nelson.api.config;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SwaggerAutoOpen {

    @EventListener(ApplicationReadyEvent.class)
    public void openSwagger() {
        try {
            URI swaggerUrl = new URI("http://localhost:8080/swagger/index.html");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(swaggerUrl);
            } else {
                System.out.println("Desktop no soportado, abre manualmente: " + swaggerUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}