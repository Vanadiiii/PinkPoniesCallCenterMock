package ru.pink.ponies.domain;

import ru.pink.ponies.web.dto.Metric;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MetricRepository {
    Optional<Metric> findById(UUID id);

    List<Metric> findAll();

    Metric save(Metric metric);

    Metric replace(Metric metric);
}
