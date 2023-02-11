package br.com.ctd.PetShopCTD2.dtos.animal;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AnimalUpdateDTO  {

    @Size(min=2, message = "Nome precisa ter ao menos 2 letras")
    private String name;
    @Positive(message = "Espécie inválida")
    private Integer specie;
    @Past(message = "Aniversário não pode ser presente ou futuro")
    private LocalDate birthdate;

    @PastOrPresent(message = "Data cadastro não pode ser futura")
    private LocalDate dateRegister;

    private Long ownerId;
    public AnimalUpdateDTO() {
    }

    public AnimalUpdateDTO(String name, Integer specie, LocalDate birthdate, LocalDate dateRegister) {
        this.name = name;
        this.specie = specie;
        this.birthdate = birthdate;
        this.dateRegister = dateRegister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpecie() {
        return specie;
    }

    public void setSpecie(Integer specie) {
        this.specie = specie;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }
}
