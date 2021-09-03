package ru.pink.ponies.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pink.ponies.domain.ShopRepository;
import ru.pink.ponies.web.dto.Good;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/mock/metrics")
@RequiredArgsConstructor
public class ShopController {
    private final ShopRepository shopRepository;

    @GetMapping("/{goodId}")
    public ResponseEntity<Good> getGoodById(@PathVariable("goodId") UUID goodId) {
        return shopRepository.findById(goodId)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @GetMapping
    public ResponseEntity<List<Good>> getAllGoods() {
        return ResponseEntity.ok(shopRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<UUID> createGood(@RequestBody Good good) {
        return ResponseEntity.ok(shopRepository.save(good).getId());
    }

    @PutMapping
    public ResponseEntity<Good> updateGood(@RequestBody Good good) {
        if (good.getId() == null) {
            throw new RuntimeException("Ooops");
        }
        return ResponseEntity.ok(shopRepository.save(good));
    }

    @Bean
    CommandLineRunner run() {
        return arg -> {
            log.info("save all goods");
            shopRepository.save(new Good(null, "T-shirt", BigDecimal.valueOf(12), "image1.png"));
            shopRepository.save(new Good(null, "Java Book", BigDecimal.valueOf(15), "image2.png"));
            shopRepository.save(new Good(null, "Teddy bear", BigDecimal.valueOf(8), "image3.png"));
            shopRepository.save(new Good(null, "Monitor", BigDecimal.valueOf(18), "image3.png"));
            shopRepository.save(new Good(null, "Robot", BigDecimal.valueOf(5), "image3.png"));
            shopRepository.save(new Good(null, "Haskell book", BigDecimal.valueOf(99), "image3.png"));
            shopRepository.save(new Good(null, "Kangaroo", BigDecimal.valueOf(10), "image3.png"));
            shopRepository.save(new Good(null, "Phone", BigDecimal.valueOf(40), "image3.png"));
            shopRepository.save(new Good(null, "pen", BigDecimal.valueOf(1), "image3.png"));
        };
    }
}
