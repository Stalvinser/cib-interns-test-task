package socks.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import socks.entity.SocksEntity;
import socks.repository.SocksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocksService {
    private final SocksRepository socksRepository;


    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public ResponseEntity<String> getSockByColorAndCottonPart(String color, String operation, int cottonPart) {
        List<SocksEntity> socksEntityList;
        switch (operation) {
            case "moreThan":
                socksEntityList =
                        socksRepository.findByColorAndCottonPartGreaterThan(color, cottonPart);
                break;
            case "lessThan":
                socksEntityList =
                        socksRepository.findByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case "equal":
                socksEntityList =
                        socksRepository.findByColorAndCottonPartEquals(color, cottonPart);
                break;
            default:
                return new ResponseEntity<>("0", HttpStatus.BAD_REQUEST);
        }
        int socksQuantity = 0;
        for (SocksEntity sock : socksEntityList) {
            System.out.println(sock.toString());
            socksQuantity += sock.getQuantity();
        }
        return new ResponseEntity<>(String.valueOf(socksQuantity), HttpStatus.OK);
    }


    public ResponseEntity<?> registerNewSocksIncome(SocksEntity sock) {
        Optional<SocksEntity> repoSock = socksRepository.findSocksEntitiesByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        if (repoSock.isPresent()) {
        SocksEntity finalSock = repoSock.get();
        finalSock.setQuantity(finalSock.getQuantity() + sock.getQuantity());
        socksRepository.save(finalSock);
        }
        else {
            socksRepository.save(sock);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



    public Iterable<SocksEntity> findAll() {
        return socksRepository.findAll();
    }


}
