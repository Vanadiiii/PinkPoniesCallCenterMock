package ru.pink.ponies.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pink.ponies.domain.MetricRepository;
import ru.pink.ponies.web.dto.Metric;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/mock/metrics")
@RequiredArgsConstructor
public class MetricController {
    private final MetricRepository metricRepository;

    @GetMapping("/{metricId}")
    public ResponseEntity<Metric> getMetricById(@PathVariable("metricId") UUID metricId) {
        return metricRepository.findById(metricId)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @GetMapping
    public ResponseEntity<List<Metric>> getAllMetrics() {
        return ResponseEntity.ok(metricRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<UUID> addMetric(@RequestBody Metric metric) {
        return ResponseEntity.ok(metricRepository.save(metric).getId());
    }

    @PutMapping
    public ResponseEntity<Metric> updateMetric(@RequestBody Metric metric) {
        if (metric.getId() == null) {
            throw new RuntimeException("Ooops");
        }
        return ResponseEntity.ok(metricRepository.save(metric));
    }
}
