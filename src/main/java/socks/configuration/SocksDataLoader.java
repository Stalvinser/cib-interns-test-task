package socks.configuration;

import org.springframework.stereotype.Component;
import socks.entity.SocksEntity;
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
                new SocksEntity("red",80,40),
                new SocksEntity("blue",10,10),
                new SocksEntity("white",30,25),
                new SocksEntity("yellow",50,3)));
    }


}
