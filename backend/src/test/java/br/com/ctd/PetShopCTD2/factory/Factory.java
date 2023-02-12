package br.com.ctd.PetShopCTD2.factory;

import br.com.ctd.PetShopCTD2.dtos.animal.AnimalDTO;
import br.com.ctd.PetShopCTD2.entites.*;
import br.com.ctd.PetShopCTD2.entites.enums.Species;

import java.time.LocalDate;

public class Factory {

    public static Animal createAnimal() {
        Animal animal = new Animal(1L, "Otto", Species.CAT, LocalDate.now(), LocalDate.now().minusMonths(2), new Owner());
        return animal;
    }

    public static AnimalDTO createAnimalDTO() {
        AnimalDTO dto = new AnimalDTO(createAnimal());
        return dto;
    }

    public static Vaccine createVaccine() {
        Vaccine vaccine = new Vaccine(1L, "Variola", 0.5);
        return vaccine;
    }

    public static CardVaccine createCardVaccine() {
        CardVaccine card = new CardVaccine(1L, LocalDate.now(), new Animal(), new Vaccine());
        return card;
    }
    public static Owner createOwner() {
        Owner owner = new Owner(1L, "Davi", "davimatosc@hotmail.com", "123456",LocalDate.now(), "60727289365");
        return owner;
    }

    public static Veterinarian createVeterinarian() {
        Veterinarian obj = new Veterinarian(1L, "Dr Strange", "strange@gmail.com","123456",LocalDate.now(), "304090-6");
        return obj;
    }
}
