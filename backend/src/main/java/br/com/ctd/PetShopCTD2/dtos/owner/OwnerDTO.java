package br.com.ctd.PetShopCTD2.dtos.owner;

import br.com.ctd.PetShopCTD2.entites.Animal;
import br.com.ctd.PetShopCTD2.entites.Owner;
import br.com.ctd.PetShopCTD2.entites.enums.Species;

import java.time.LocalDate;

public class OwnerDTO {
    private long id;
    private String name;
    private String cpf;
    private LocalDate dateRegister;
    private int qttAniamls;
    private String email;

    public OwnerDTO() {
    }

    public OwnerDTO(long id, String name, String cpf, LocalDate dateRegister, int qttAniamls, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateRegister = dateRegister;
        this.qttAniamls = qttAniamls;
        this.email = email;
    }

    public OwnerDTO(Owner obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.dateRegister = obj.getDateRegister();
        this.cpf = obj.getCpf();
        this.qttAniamls = obj.getAnimals().size();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public int getQttAniamls() {
        return qttAniamls;
    }

    public void setQttAniamls(int qttAniamls) {
        this.qttAniamls = qttAniamls;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
