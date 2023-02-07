package br.com.ctd.PetShopCTD2.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class CardVaccine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;


    public CardVaccine() {
    }

    public CardVaccine(Long id, LocalDate date, Animal animal, Vaccine vaccine) {
        this.id = id;
        this.date = date;
        this.animal = animal;
        this.vaccine = vaccine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardVaccine vacina = (CardVaccine) o;
        return id.equals(vacina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
