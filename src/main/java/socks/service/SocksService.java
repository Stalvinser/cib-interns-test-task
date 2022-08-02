package socks.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socks.exception.SocksBadRequestException;
import socks.model.Socks;
import socks.repository.SocksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocksService implements ISocksService{
    private final SocksRepository socksRepository;


    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public String getSockByColorAndCottonPart(String color, String operation, int cottonPart) {
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
                throw new SocksBadRequestException("Invalid operation request");
        }
        int socksQuantity = 0;
        for (Socks sock : socksList) {
            System.out.println(sock.toString());
            socksQuantity += sock.getQuantity();
        }
        return  String.valueOf(socksQuantity);
    }

    @Transactional
    public void registerNewSocksIncome (Socks sock) {
        Optional<Socks> repoSock = socksRepository.findSocksEntitiesByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        if (repoSock.isPresent()) {
            Socks finalSock = repoSock.get();
            finalSock.setQuantity(finalSock.getQuantity() + sock.getQuantity());
            socksRepository.save(finalSock);
        }
        else {
            socksRepository.save(sock);
        }

    }


    public Iterable<Socks> findAll() {
        return socksRepository.findAll();
    }


}
