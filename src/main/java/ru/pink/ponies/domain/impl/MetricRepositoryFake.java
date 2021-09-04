package ru.pink.ponies.domain.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.pink.ponies.domain.MetricRepository;
import ru.pink.ponies.web.dto.Metric;
import ru.pink.ponies.web.dto.MetricType;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
public class MetricRepositoryFake implements MetricRepository {
    private final Map<UUID, Metric> storage = new HashMap<>();

    @Override
    public Optional<Metric> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Metric> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Metric save(Metric metric) {
        UUID id = UUID.randomUUID();
        metric.setId(id);
        storage.put(id, metric);

        return metric;
    }

    @Override
    public Metric replace(Metric metric) {
        storage.put(metric.getId(), metric);
        return metric;
    }

    @PostConstruct
    void init() {
        log.info("save all goods");
        save(
                new Metric(null, MetricType.DEPARTMENT, new HashMap<>() {{
                    this.put("operatorUtilization", 5d);
                    this.put("throughput", 15d);
                    this.put("SLA", 77d);
                }})
        );
        save(
                new Metric(null, MetricType.GROUP, new HashMap<>() {{
                    this.put("types", 15d);
                    this.put("hourlyDocCount", 2d);
                    this.put("shiftDocCount", 15d);
                    this.put("monthDocCount", 150d);
                    this.put("corectPercentage", 98d);
                }})
        );
        save(
                new Metric(null, MetricType.SINGLE, new HashMap<>() {{
                    this.put("types", 8d);
                    this.put("hourlyDocCount", 7d);
                    this.put("shiftDocCount", 18d);
                    this.put("monthDocCount", 200d);
                    this.put("corectPercentage", 89d);
                }})
        );
        save(
                new Metric(null, MetricType.SINGLE, new HashMap<>() {{
                    this.put("types", 4d);
                    this.put("hourlyDocCount", 8d);
                    this.put("shiftDocCount", 16d);
                    this.put("monthDocCount", 300d);
                    this.put("corectPercentage", 99d);
                }})
        );
        save(
                new Metric(null, MetricType.GROUP, new HashMap<>() {{
                    this.put("types", 16d);
                    this.put("hourlyDocCount", 19d);
                    this.put("shiftDocCount", 28d);
                    this.put("monthDocCount", 500d);
                    this.put("corectPercentage", 100d);
                }})
        );
        save(
                new Metric(null, MetricType.SINGLE, new HashMap<>() {{
                    this.put("types", 11d);
                    this.put("hourlyDocCount", 5d);
                    this.put("shiftDocCount", 19d);
                    this.put("monthDocCount", 222d);
                    this.put("corectPercentage", 80d);
                }})
        );
        save(
                new Metric(null, MetricType.DEPARTMENT, new HashMap<>() {{
                    this.put("operatorUtilization", 1d);
                    this.put("throughput", 20d);
                    this.put("SLA", 88d);
                }})
        );
        save(
                new Metric(null, MetricType.SINGLE, new HashMap<>() {{
                    this.put("types", 10d);
                    this.put("hourlyDocCount", 39d);
                    this.put("shiftDocCount", 40d);
                    this.put("monthDocCount", 500d);
                    this.put("corectPercentage", 100d);
                }})
        );
        save(
                new Metric(null, MetricType.GROUP, new HashMap<>() {{
                    this.put("types", 15d);
                    this.put("hourlyDocCount", 19d);
                    this.put("shiftDocCount", 200d);
                    this.put("monthDocCount", 2000d);
                    this.put("corectPercentage", 50d);
                }})
        );
    }
}
