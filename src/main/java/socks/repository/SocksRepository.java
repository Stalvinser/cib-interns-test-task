package socks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import socks.entity.SocksEntity;

import java.util.List;

@Repository
public interface SocksRepository extends CrudRepository<SocksEntity, Long> {

    List<SocksEntity> findByColorAndCottonPartEquals(String color, Integer cottonPart);
    List<SocksEntity> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
    List<SocksEntity> findByColorAndCottonPartLessThan(String color, Integer cottonPart);

}
