package cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.mappers;

import cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.entities.FruitEntity;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;

public final class FruitMappers {

    static public Fruit toDomain(FruitEntity entity) {

        return new Fruit(entity.getId(), entity.getName(), entity.getQuantity());

    }

    static public FruitEntity toEntity(Fruit fruit) {

        return new FruitEntity(fruit.getId(), fruit.getName(), fruit.getQuantity());

    }

}
