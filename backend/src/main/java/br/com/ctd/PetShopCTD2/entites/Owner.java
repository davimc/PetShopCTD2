package br.com.ctd.PetShopCTD2.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends Person {

    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "owner")
    private List<Animal> animals = new ArrayList<>();

    public Owner() {
    }

    public Owner(Long id, String name, String email, String password, LocalDate dateRegister, String cpf) {
        super(id, name, email, password, dateRegister);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
