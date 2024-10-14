package cat.itacademy.s04.t02.n01.S04T02N01.application;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers.FruitMappers;
import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.FindFruitById;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Primary
@Service
@RequiredArgsConstructor
public final class FindFruitByIdService implements FindFruitById {

    private final FruitRepository fruitRepository;

    @Override
    public Optional<Fruit> findFruitById(Long id) {

        return fruitRepository.findById(id).map(FruitMappers::toDomain);

    }

}
