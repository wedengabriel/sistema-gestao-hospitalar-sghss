package com.sghss.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, String> readRoot() {

        Map<String, String> response = new HashMap<>();

        response.put(
                "Mensagem",
                "API Java Spring Boot funcionando! Acesse a documentação em /swagger-ui/index.html"
        );

        return response;
    }
}