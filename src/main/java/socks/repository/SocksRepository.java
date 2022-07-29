package socks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import socks.entity.SocksEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends CrudRepository<SocksEntity, Long> {

    List<SocksEntity> findByColorAndCottonPartEquals(String color, Integer cottonPart);
    List<SocksEntity> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
    List<SocksEntity> findByColorAndCottonPartLessThan(String color, Integer cottonPart);

    Optional<SocksEntity> findSocksEntitiesByColorAndCottonPart(String color, Integer cottonPart);


}
