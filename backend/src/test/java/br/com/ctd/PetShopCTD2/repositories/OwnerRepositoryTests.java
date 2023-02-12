package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Owner;
import br.com.ctd.PetShopCTD2.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.Assert;

import java.util.Optional;

@DataJpaTest
public class OwnerRepositoryTests {

    @Autowired
    private OwnerRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalOwners;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalOwners = 50L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Owner owner = Factory.createOwner();
        owner.setId(null);
        System.out.println(repository.count());
        System.out.println(owner.getId());
        owner = repository.save(owner);
        System.out.println(owner.getId());
        Optional<Owner> result = repository.findById(owner.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), owner);
        Assertions.assertNotNull(owner.getId());

        Assertions.assertEquals(countTotalOwners + 1L, owner.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Owner> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
