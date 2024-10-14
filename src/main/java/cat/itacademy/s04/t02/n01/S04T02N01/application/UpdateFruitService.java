package cat.itacademy.s04.t02.n01.S04T02N01.application;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.entities.FruitEntity;
import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers;
import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.UpdateFruit;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers.toDomain;
import static cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers.toEntity;

@Primary
@Service
@RequiredArgsConstructor
public final class UpdateFruitService implements UpdateFruit {

    private final FruitRepository fruitRepository;

    @Override
    public Fruit updateFruit(Fruit fruit) {

        Optional<Fruit> oldFruitOpt = fruitRepository.findById(fruit.getId()).map(FruitMappers::toDomain);

        if (oldFruitOpt.isEmpty())
            throw new IllegalArgumentException("Cannot update. Fruit with ID " + fruit.getId() + " doesn't exist.");

        Fruit oldFruit = oldFruitOpt.get();

        if (fruit.equals(oldFruit))
            return oldFruit;

        FruitEntity updatedEntity = toEntity(fruit);

        return toDomain(fruitRepository.save(updatedEntity));

    }

}
