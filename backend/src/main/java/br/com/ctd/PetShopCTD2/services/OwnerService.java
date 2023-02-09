package br.com.ctd.PetShopCTD2.services;

import br.com.ctd.PetShopCTD2.dtos.owner.OwnerDTO;
import br.com.ctd.PetShopCTD2.dtos.owner.OwnerNewDTO;
import br.com.ctd.PetShopCTD2.entites.Owner;
import br.com.ctd.PetShopCTD2.repositories.OwnerRepository;
import br.com.ctd.PetShopCTD2.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public Page<OwnerDTO> findAll(Pageable pageable) {
        Page<Owner> obj = repository.findAll(pageable);
        return obj.map(OwnerDTO::new);
    }

    protected Owner find(Long id) {
        return (repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Owner.class);
        }));
    }
    public OwnerDTO findDto(Long id) {
        return new OwnerDTO(find(id));
    }

    public OwnerDTO insert(OwnerNewDTO dto) {
        Owner obj = fromDTO(dto);
        obj.setDateRegister(LocalDate.now());

        obj = repository.save(obj);

        return new OwnerDTO(obj);
    }

    private Owner fromDTO(OwnerNewDTO dto) {
        Owner obj = new Owner();
        obj.setCpf(dto.getCpf());
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());

        return obj;
    }
}
