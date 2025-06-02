package com.example.demo.service;

import com.example.demo.dto.BpmnProcess;
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


    public void startCheckDmnProcess(){

        String businessKey = generateBusinessKey();
        Map<String, Object> vars = new HashMap<>();
        vars.put("type", "value");

        runtimeService.startProcessInstanceByKey(BpmnProcess.CHECK_DMN_RULES.getId(), businessKey, vars);
    }
}
