package br.com.ctd.PetShopCTD2.entites.enums;

public enum Species {
    CAT(1, "Gato"), DOG(2, "Cachorro"),
    BIRD(3, "Pássaro");

    private Integer cod;
    private String description;

    Species(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Species toEnum(Integer cod) {
        if(cod == null) return null;
        for(Species s: Species.values())
            if(cod.equals(s.getCod()))
                return s;
        throw new IllegalArgumentException("Opção inválida");
    }
}
