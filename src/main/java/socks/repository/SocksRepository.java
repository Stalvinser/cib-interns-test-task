package socks.repository;

import org.springframework.data.repository.CrudRepository;
import socks.model.Socks;

import java.util.List;
import java.util.Optional;

public interface SocksRepository extends CrudRepository<Socks, Long> {

    List<Socks> findByColorAndCottonPartEquals(String color, Integer cottonPart);
    List<Socks> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
    List<Socks> findByColorAndCottonPartLessThan(String color, Integer cottonPart);

    Optional<Socks> findSocksEntitiesByColorAndCottonPart(String color, Integer cottonPart);


}
