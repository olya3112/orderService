package com.example.demo.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CheckDMNService {

    private final RuntimeService runtimeService;
    private final Random random = new Random();

    public CheckDMNService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    /**
     * Генерирует бизнес-ключ формата mma_XXXX, где XXXX — 4 цифры с ведущими нулями.
     */
    private String generateBusinessKey() {
        int number = random.nextInt(10_000); // от 0 до 9999
        return String.format("mma_%04d", number);
    }

    /**
     * Запускает процесс simple_project с уникальным бизнес-ключом и передаёт переменные.
     */
    public void startSimpleProcess() throws InterruptedException {
        String businessKey = generateBusinessKey();

        Map<String, Object> variables = new HashMap<>();
        variables.put("type", "value"); // Добавьте нужные переменные процесса

        runtimeService.startProcessInstanceByKey("simple_project", businessKey, variables);
        Thread.sleep(3000);
        System.out.println("Процесс simple_project запущен с бизнес-ключом: " + businessKey);
    }
}
