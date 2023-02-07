package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Animal;
import br.com.ctd.PetShopCTD2.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class AnimalRepositoryTests {

    @Autowired
    private AnimalRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalAnimals;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        //todo atualizar
        countTotalAnimals = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

        Animal animal = Factory.createAnimal();
        animal.setId(null);

        animal = repository.save(animal);
        Optional<Animal> result = repository.findById(animal.getId());

        Assertions.assertNotNull(animal.getId());
        Assertions.assertEquals(countTotalAnimals + 1L, animal.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), animal);
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Animal> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
