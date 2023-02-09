package br.com.ctd.PetShopCTD2.dtos.owner;

import br.com.ctd.PetShopCTD2.entites.Owner;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class OwnerNewDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 3, message = "Nome precisa ter no mínimo 3 letras")
    private String name;

    @NotNull(message = "CPF não pode ser vazio")
    @CPF(message = "Formato de CPF inválido")
    private String cpf;

    @NotNull(message = "Email não pode ser vazio")
    @Email(message = "Formato de Email inválido")
    private String email;

    @NotNull(message = "Password não pode ser vazio")
    @Size(min = 6, message = "Passowrd precisa ter no mínimo 6 dígitos")
    private String password;

    public OwnerNewDTO() {
    }

    public OwnerNewDTO(String name, String cpf, String email,String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public OwnerNewDTO(Owner obj) {
        this.cpf = obj.getCpf();
        name = obj.getName();
        email = obj.getEmail();
        password = obj.getPassword();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
