package cat.itacademy.s04.t02.n01.S04T02N01.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public final class Fruit {

    private final Long id;
    private final String name;
    private final Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit fruit)) return false;
        return Objects.equals(getId(), fruit.getId()) && Objects.equals(getName(), fruit.getName()) && Objects.equals(getQuantity(), fruit.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getQuantity());
    }

}
