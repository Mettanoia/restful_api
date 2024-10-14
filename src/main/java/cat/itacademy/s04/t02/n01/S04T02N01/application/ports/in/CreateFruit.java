package cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in;

import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;

@FunctionalInterface
public interface CreateFruit {
    Fruit createFruit(Fruit fruit);
}
