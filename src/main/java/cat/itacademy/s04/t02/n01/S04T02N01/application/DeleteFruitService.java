package cat.itacademy.s04.t02.n01.S04T02N01.application;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.repositories.FruitRepository;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.DeleteFruit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Primary
@Service
@RequiredArgsConstructor
public final class DeleteFruitService implements DeleteFruit {

    private final FruitRepository fruitRepository;

    @Override
    public void deleteFruit(Long id) {

        fruitRepository.deleteById(id);

    }

}
