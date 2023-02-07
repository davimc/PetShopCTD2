package br.com.ctd.PetShopCTD2.entites;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    private LocalDateTime dateAppoitment;
    private LocalDateTime dateoCurred;
    private LocalDateTime dateCancellation;
    //TODO enum AppointmentType
    private String type;
    //TODO enum AppointmentStatus
    private String status;
    private Animal animal;
    private Veterinarian veterinarian;

    //@OneToOne
    private Rating rating;

}
