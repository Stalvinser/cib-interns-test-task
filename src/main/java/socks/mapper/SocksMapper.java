package socks.mapper;

import socks.dto.SocksDTO;
import socks.model.Socks;

public class SocksMapper {
    public static Socks DtoToEntity(SocksDTO socksDTO) {
        return new Socks().setColor(socksDTO.getColor())
                .setCottonPart(socksDTO.getCottonPart())
                .setQuantity(socksDTO.getQuantity());
    }
    public static SocksDTO EntityToDTO(Socks socks) {
        return new SocksDTO().setColor(socks.getColor())
                .setCottonPart(socks.getCottonPart())
                .setQuantity(socks.getQuantity());
    }
}
