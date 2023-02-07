package br.com.ctd.PetShopCTD2.entites;

import java.time.LocalDate;


//Talvez não implemente essa funcionalidade, por fugir do escopo
public class Rating {
    private Long id;
    private LocalDate date;
    private Double punctuation;
    private String comment;

    private Owner owner;

    //@OneToOne
    private Appointment appointment;
}
