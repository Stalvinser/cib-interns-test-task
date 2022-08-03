package socks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseStatusExceptionHandler {

    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Requested Student Not Found")
    @ExceptionHandler(SocksNotFoundException.class)
    public ResponseEntity<Error> handleException(SocksNotFoundException e) {
        System.out.println(e.getLocalizedMessage()); //AAAAAAAAAAAA
        Error error = new Error(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "Received Invalid Input Parameters")
    @ExceptionHandler(SocksBadRequestException.class)
    public ResponseEntity<Error> handleException(SocksBadRequestException e) {
        System.out.println(e.getMessage()); //AAAAAAAAAAAA
        Error error = new Error(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }


}