package br.com.ctd.PetShopCTD2.repositories;

import br.com.ctd.PetShopCTD2.entites.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
