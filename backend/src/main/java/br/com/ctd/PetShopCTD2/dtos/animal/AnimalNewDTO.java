package br.com.ctd.PetShopCTD2.dtos.animal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AnimalNewDTO {

    @NotNull(message = "Nome Não pode ser nulo")
    @Size(min=2, message = "Nome precisa ter ao menos 2 letras")
    private String name;
    @Positive(message = "Espécie inválida")
    private int specie;
    @Past(message = "Aniversário não pode ser presente ou futuro")
    private LocalDate birthdate;

    @NotNull(message = "É necessário informar o responsável do animal")
    private long ownerId;

    public AnimalNewDTO() {
    }

    public AnimalNewDTO(String name, int specie, LocalDate birthdate, long ownerId) {
        this.name = name;
        this.specie = specie;
        this.birthdate = birthdate;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecie() {
        return specie;
    }

    public void setSpecie(int specie) {
        this.specie = specie;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
