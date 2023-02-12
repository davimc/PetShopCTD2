package br.com.ctd.PetShopCTD2.controllers.exceptions;

import br.com.ctd.PetShopCTD2.services.exceptions.ForbbidenException;
import br.com.ctd.PetShopCTD2.services.exceptions.ObjectNotFoundException;
import br.com.ctd.PetShopCTD2.services.exceptions.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OAuthError> unauthorized(UnauthorizedException e, HttpServletRequest request){
        OAuthError error = new OAuthError("Unauthorized", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    @ExceptionHandler(ForbbidenException.class)
    public ResponseEntity<OAuthError> forbbiden(ForbbidenException e, HttpServletRequest request){
        OAuthError error = new OAuthError("Forbbiden", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
}