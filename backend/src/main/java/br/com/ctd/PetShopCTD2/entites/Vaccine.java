package br.com.ctd.PetShopCTD2.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Vaccine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double minimalAge;

    public Vaccine() {
    }

    public Vaccine(Long id, String name, Double recommendedAge) {
        this.id = id;
        this.name = name;
        this.minimalAge = recommendedAge;
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

    public Double getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(Double minimalAge) {
        this.minimalAge = minimalAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vacina = (Vaccine) o;
        return id.equals(vacina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
