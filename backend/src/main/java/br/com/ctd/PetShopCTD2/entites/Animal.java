package br.com.ctd.PetShopCTD2.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private Long id;
    private String name;
    private String species;
    private String race;
    private LocalDate dateRegister;
    private LocalDate birthDate;
    // TODO enum color
    private String color;
    private Owner owner;
    private List<Appointment> appointments = new ArrayList<>();

}
