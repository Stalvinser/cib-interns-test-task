package socks.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socks.model.Socks;
import socks.repository.SocksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocksService implements ISocksService {
    private final SocksRepository socksRepository;


    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Override
    public ResponseEntity<String> getSockByColorAndCottonPart(String color, String operation, int cottonPart) {
        List<Socks> socksList;
        switch (operation) {
            case "moreThan":
                socksList =
                        socksRepository.findByColorAndCottonPartGreaterThan(color, cottonPart);
                break;
            case "lessThan":
                socksList =
                        socksRepository.findByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case "equal":
                socksList =
                        socksRepository.findByColorAndCottonPartEquals(color, cottonPart);
                break;
            default:
                return new ResponseEntity<>("Invalid operation request", HttpStatus.BAD_REQUEST);
        }
        int socksQuantity = 0;
        for (Socks sock : socksList) {
            System.out.println(sock.toString());
            socksQuantity += sock.getQuantity();
        }
        return new ResponseEntity<>(String.valueOf(socksQuantity), HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @Override
    public ResponseEntity<?> registerNewSocksIncome(Socks sock) {
        Optional<Socks> repoSock = socksRepository.findSocksEntitiesByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        if (repoSock.isPresent()) {
            Socks finalSock = new Socks(repoSock.get().getColor(),
                    repoSock.get().getCottonPart(), repoSock.get().getQuantity());
            finalSock.setQuantity(finalSock.getQuantity() + sock.getQuantity());
            socksRepository.save(finalSock);
            return new ResponseEntity<>("Socks income registered", HttpStatus.OK);
        } else {
            socksRepository.save(sock);
            return new ResponseEntity<>("New socks income registered", HttpStatus.OK);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<?> registerNewSocksOutcome(Socks sock) {
        Optional<Socks> repoSock = socksRepository.findSocksEntitiesByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        if (repoSock.isPresent()) {
            if (repoSock.get().getQuantity() >= sock.getQuantity()) {
                Socks tempSock = new Socks(repoSock.get().getColor(),
                        repoSock.get().getCottonPart(), repoSock.get().getQuantity());
                tempSock.setQuantity(tempSock.getQuantity() - sock.getQuantity());
                socksRepository.save(tempSock);
                return new ResponseEntity<>("Socks outcome registered", HttpStatus.OK);
            } else
                return new ResponseEntity<>("not enough socks at warehouse, socks stored at warehouse = "
                        + repoSock.get().getQuantity() +
                        " socks ordered for outcome = " + sock.getQuantity(), HttpStatus.BAD_REQUEST);
        } else
            return new ResponseEntity<>("no such color " + sock.getColor() +
                    " with cottonpart value " + sock.getCottonPart() + " at warehouse", HttpStatus.BAD_REQUEST);

    }

    @Override
    public Iterable<Socks> findAll() {
        return socksRepository.findAll();
    }


}
