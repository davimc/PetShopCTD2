package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Vaccine;
import br.com.ctd.PetShopCTD2.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class VaccineRepositoryTests {

    @Autowired
    private VaccineRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalVaccines;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        //todo atualizar
        countTotalVaccines = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

        Vaccine vaccine = Factory.createVaccine();
        vaccine.setId(null);

        vaccine = repository.save(vaccine);
        Optional<Vaccine> result = repository.findById(vaccine.getId());

        Assertions.assertNotNull(vaccine.getId());
        Assertions.assertEquals(countTotalVaccines + 1L, vaccine.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), vaccine);
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Vaccine> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
