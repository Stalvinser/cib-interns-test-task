package socks.service;

import org.springframework.http.ResponseEntity;
import socks.model.Socks;

import java.util.List;
import java.util.Optional;

public interface ISocksService {
    String getSockByColorAndCottonPart(String color, String operation, int cottonPart);

    void registerNewSocksIncome(Socks sock);

    Iterable<Socks> findAll();

}
