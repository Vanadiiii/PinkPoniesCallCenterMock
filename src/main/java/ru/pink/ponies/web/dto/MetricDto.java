package ru.pink.ponies.web.dto;

import lombok.Data;

import java.util.Map;

@Data
public class MetricDto {
    private String id;
    private MetricType type;
    private Map<String, Object> metrics;
}
