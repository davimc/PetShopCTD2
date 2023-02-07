package br.com.ctd.PetShopCTD2.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veterinarian extends Person {
    @Column(unique = true)
    private String license;

    @OneToMany(mappedBy = "veterinarian")
    private List<Appointment> appointments = new ArrayList<>();

    public Veterinarian() {
    }

    public Veterinarian(Long id, String name, String email, String password, LocalDate dateRegister, String license) {
        super(id, name, email, password, dateRegister);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
