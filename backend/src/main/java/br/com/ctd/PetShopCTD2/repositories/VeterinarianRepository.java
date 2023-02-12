package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

}
