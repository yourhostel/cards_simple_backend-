package com.tysser.cards.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${custom.cors.allowedOrigins}")
    private String allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Включает CORS запросы для всех URL.
                .allowedOrigins(allowedOrigins) // Укажите домен клиентской части, который будет разрешен. Используйте "*" для разрешения всех доменов.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные методы запросов.
                .allowedHeaders("*") // Разрешенные заголовки.
                .allowCredentials(true); // Если вам нужно отправлять cookies.
    }
}
