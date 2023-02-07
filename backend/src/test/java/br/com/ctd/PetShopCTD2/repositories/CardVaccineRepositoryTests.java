package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.CardVaccine;
import br.com.ctd.PetShopCTD2.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class CardVaccineRepositoryTests {

    @Autowired
    private CardVaccineRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalCardVaccines;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        //todo atualizar
        countTotalCardVaccines = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

        CardVaccine card = Factory.createCardVaccine();
        card.setId(null);

        card = repository.save(card);
        Optional<CardVaccine> result = repository.findById(card.getId());

        Assertions.assertNotNull(card.getId());
        Assertions.assertEquals(countTotalCardVaccines + 1L, card.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), card);
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<CardVaccine> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
