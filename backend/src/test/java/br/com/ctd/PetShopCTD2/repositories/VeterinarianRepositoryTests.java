package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Veterinarian;
import br.com.ctd.PetShopCTD2.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class VeterinarianRepositoryTests {

    @Autowired
    private VeterinarianRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalVeterinarians;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 26L;
        nonExistingId = 1000L;
        countTotalVeterinarians = 50L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Veterinarian obj = Factory.createVeterinarian();
        obj.setId(null);
        System.out.println(repository.count());
        System.out.println(obj.getId());
        obj = repository.save(obj);
        System.out.println(obj.getId());
        Optional<Veterinarian> result = repository.findById(obj.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), obj);
        Assertions.assertNotNull(obj.getId());
        Assertions.assertEquals(countTotalVeterinarians + 1L, obj.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Veterinarian> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
