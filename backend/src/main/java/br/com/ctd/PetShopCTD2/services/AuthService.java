package br.com.ctd.PetShopCTD2.services;

import br.com.ctd.PetShopCTD2.entites.User;
import br.com.ctd.PetShopCTD2.repositories.UserRepository;
import br.com.ctd.PetShopCTD2.services.exceptions.ForbbidenException;
import br.com.ctd.PetShopCTD2.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try{
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByEmail(username).get();
        }catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    @Transactional(readOnly = true)
    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();

        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN"))
            throw new ForbbidenException("Access denied");
    }
}
