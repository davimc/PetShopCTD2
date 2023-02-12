package br.com.ctd.PetShopCTD2.dtos.user;

import br.com.ctd.PetShopCTD2.entites.User;

public class UserDTO {

    private Long id;
    private String name;

    public UserDTO() {
    }

    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
