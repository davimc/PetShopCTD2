package br.com.ctd.PetShopCTD2.factory;

import br.com.ctd.PetShopCTD2.entites.Animal;
import br.com.ctd.PetShopCTD2.entites.CardVaccine;
import br.com.ctd.PetShopCTD2.entites.Owner;
import br.com.ctd.PetShopCTD2.entites.Vaccine;
import br.com.ctd.PetShopCTD2.entites.enums.Species;

import java.time.LocalDate;

public class Factory {

    public static Animal createAnimal() {
        Animal animal = new Animal(1L, "Otto", Species.CAT, LocalDate.now(), LocalDate.now().minusMonths(2), new Owner());
        return animal;
    }

    public static Vaccine createVaccine() {
        Vaccine vaccine = new Vaccine(1L, "Variola", 0.5);
        return vaccine;
    }

    public static CardVaccine createCardVaccine() {
        CardVaccine card = new CardVaccine(1L, LocalDate.now(), new Animal(), new Vaccine());
        return card;
    }

}
