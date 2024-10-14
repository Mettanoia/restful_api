package cat.itacademy.s04.t02.n01.S04T02N01.adapter.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class FruitEntity
{

    @Id
    @GeneratedValue(strategy = IDENTITY)  // Auto-generate IDs
    private Long id;

    private String name;
    private Integer quantity;

}