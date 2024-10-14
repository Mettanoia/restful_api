package cat.itacademy.s04.t02.n01.S04T02N01.application;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers;
import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.FindAllFruits;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.stream.StreamSupport.stream;

@Primary
@Service
@RequiredArgsConstructor
public final class FindAllFruitsService implements FindAllFruits {

    private final FruitRepository fruitRepository;

    @Override
    public Collection<Fruit> findAllFruits() {

        return stream(fruitRepository.findAll().spliterator(), false)
                .map(FruitMappers::toDomain)
                .toList();

    }

}
