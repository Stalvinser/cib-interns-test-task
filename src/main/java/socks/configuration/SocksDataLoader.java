package socks.configuration;

import org.springframework.stereotype.Component;
import socks.model.Socks;
import socks.repository.SocksRepository;

import java.util.List;

@Component
public class SocksDataLoader {

    private final SocksRepository socksRepository;

    public SocksDataLoader(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    //@PostConstruct
    private void loadData() {
        socksRepository.saveAll(List.of(
                new Socks("red",80,40),
                new Socks("blue",10,10),
                new Socks("white",30,25),
                new Socks("yellow",50,3)));
    }


}
