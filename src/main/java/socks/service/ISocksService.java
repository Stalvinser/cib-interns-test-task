package socks.service;

import org.springframework.http.ResponseEntity;
import socks.model.Socks;

import java.util.List;
import java.util.Optional;

public interface ISocksService {
    ResponseEntity<String> getSockByColorAndCottonPart(String color, String operation, int cottonPart);

    ResponseEntity<?> registerNewSocksIncome(Socks sock);

    ResponseEntity<?> registerNewSocksOutcome (Socks sock);

    Iterable<Socks> findAll();

}
