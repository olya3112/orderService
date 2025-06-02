package com.example.demo.controller;
import com.example.demo.service.CheckDMNService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckDmnController {

    private final CheckDMNService checkDMNService;

    public CheckDmnController(CheckDMNService checkDMNService) {
        this.checkDMNService = checkDMNService;
    }

    @PostMapping("/start-process")
    public String startProcess() throws InterruptedException {
        checkDMNService.startCheckDmnProcess();
        return "Процесс запущен!";
    }
}
