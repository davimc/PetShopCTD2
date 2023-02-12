package br.com.ctd.PetShopCTD2.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class Owner extends User {

    @Column(unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
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
