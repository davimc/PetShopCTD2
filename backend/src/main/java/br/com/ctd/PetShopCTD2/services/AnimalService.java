package br.com.ctd.PetShopCTD2.services;

import br.com.ctd.PetShopCTD2.dtos.animal.AnimalDTO;
import br.com.ctd.PetShopCTD2.dtos.animal.AnimalNewDTO;
import br.com.ctd.PetShopCTD2.entites.Animal;
import br.com.ctd.PetShopCTD2.repositories.AnimalRepository;
import br.com.ctd.PetShopCTD2.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private OwnerService ownerService;

    public Page<AnimalDTO> findAll(Pageable pageable) {
        Page<Animal> obj = repository.findAll(pageable);
        return obj.map(AnimalDTO::new);
    }

    protected  Animal find(Long id) {
        return (repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Animal.class);
        }));
    }
    public AnimalDTO findDto(Long id) {
        return new AnimalDTO(find(id));
    }

    public AnimalDTO insert(AnimalNewDTO dto) {
        Animal obj = fromDTO(dto);

        obj.setDateRegister(LocalDate.now());
        obj.setOwner(ownerService.find(dto.getOwnerId()));

        obj = repository.save(obj);

        return new AnimalDTO(obj);
    }

    private Animal fromDTO(AnimalNewDTO dto) {
        Animal obj = new Animal();

        obj.setName(dto.getName());
        obj.setBirthdate(dto.getBirthdate());
        obj.setSpecies(dto.getSpecie());

        return obj;
    }
}
