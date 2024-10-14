package cat.itacademy.s04.t02.n01.S04T02N01.application;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.CreateFruit;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import static cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers.toDomain;
import static cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers.toEntity;

@Primary
@Service
@RequiredArgsConstructor
public final class CreateFruitService implements CreateFruit {

    private final FruitRepository fruitRepository;

    @Override
    public Fruit createFruit(Fruit fruit) {

        return toDomain(fruitRepository.save(toEntity(fruit)));

    }

}
