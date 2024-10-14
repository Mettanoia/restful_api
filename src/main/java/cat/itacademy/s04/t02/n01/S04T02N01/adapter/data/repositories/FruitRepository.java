package cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.entities.FruitEntity;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<FruitEntity, Long> {

    @Override
    void deleteById(Long id);
}
