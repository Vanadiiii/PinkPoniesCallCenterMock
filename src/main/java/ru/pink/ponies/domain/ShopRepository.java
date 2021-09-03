package ru.pink.ponies.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pink.ponies.web.dto.Good;

import java.util.UUID;

public interface ShopRepository extends JpaRepository<Good, UUID> {
}
