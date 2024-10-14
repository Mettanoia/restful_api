package cat.itacademy.s04.t02.n01.S04T02N01.adapter.controllers;

import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.CreateFruit;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.DeleteFruit;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.FindAllFruits;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.FindFruitById;
import cat.itacademy.s04.t02.n01.S04T02N01.application.ports.in.UpdateFruit;
import cat.itacademy.s04.t02.n01.S04T02N01.domain.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fruits")
public final class FruitController {

    private final CreateFruit createFruitService;
    private final UpdateFruit updateFruitService;
    private final DeleteFruit deleteFruitService;
    private final FindAllFruits findAllFruitsService;
    private final FindFruitById findFruitByIdService;

    // Create a new fruit
    @PostMapping
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit payload) {
        Fruit createdFruit = createFruitService.createFruit(payload);
        return new ResponseEntity<>(createdFruit, CREATED);
    }

    // Update an existing fruit
    @PutMapping("/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody Fruit payload) {
        if (!Objects.equals(payload.getId(), id))
            return status(BAD_REQUEST).build();

        try {
            Fruit updatedFruit = updateFruitService.updateFruit(payload);
            return ok(updatedFruit);
        } catch (NoSuchElementException e) {
            return status(NOT_FOUND).build();
        }

    }

    // Delete a fruit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id) {

        try {
            deleteFruitService.deleteFruit(id);
            return noContent().build();
        } catch (NoSuchElementException e) {
            return status(NOT_FOUND).build();
        }

    }

    // Get a fruit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        try {

            Optional<Fruit> fruit = findFruitByIdService.findFruitById(id);

            if (fruit.isEmpty())
                throw new NoSuchElementException();

            return ok(fruit.get());

        } catch (NoSuchElementException e) {
            return status(NOT_FOUND).build();
        }

    }

    // Get all fruits
    @GetMapping
    public ResponseEntity<Collection<Fruit>> getAllFruits() {

        Collection<Fruit> fruits = findAllFruitsService.findAllFruits();
        return ok(fruits);

    }

}
