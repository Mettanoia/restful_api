package cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in;

import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;

import java.util.Optional;

public interface FindFruitById {
    Optional<Fruit> findFruitById(Long id);
}
