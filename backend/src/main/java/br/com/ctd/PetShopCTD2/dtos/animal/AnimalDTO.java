package br.com.ctd.PetShopCTD2.dtos.animal;

import br.com.ctd.PetShopCTD2.entites.Animal;
import br.com.ctd.PetShopCTD2.entites.enums.Species;

import java.time.LocalDate;

public class AnimalDTO {
    private long id;
    private String name;
    private String specie;
    private LocalDate dateRegister;
    private LocalDate birthdate;
    private long ownerId;
    private String ownerName;

    public AnimalDTO() {
    }

    public AnimalDTO(long id, String name, String specie, LocalDate dateRegister, LocalDate birthdate, long ownerId, String ownerName) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.dateRegister = dateRegister;
        this.birthdate = birthdate;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public AnimalDTO(Animal obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.specie = Species.toEnum(obj.getSpecies()).getDescription();
        this.dateRegister = obj.getDateRegister();
        this.birthdate = obj.getBirthdate();
        this.ownerId = obj.getOwner().getId();
        this.ownerName = obj.getOwner().getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
