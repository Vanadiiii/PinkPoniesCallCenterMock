package ru.pink.ponies.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metric {
    private UUID id;
    private MetricType type;
    private Map<String, Double> metrics;
}
