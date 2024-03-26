package com.practice.diplom;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "DIPLOM",
        description = "Клиентская часть для диплома",
        version = "1.0.0",
        contact = @Contact(
                name = "Струшко Данила",
                email = "danya.strushko@mail.ru"
        )
)
)
public class DiplomApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomApplication.class, args);
    }

}
