package com.example.demo.dto;

public enum BpmnProcess {
    CHECK_DMN_RULES("check_dmn_rules");

    private final String id;

    BpmnProcess(String id) { this.id = id;}

    public String getId() {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        return id;
    }
}
