package pi.banka.service.mapper;

import org.mapstruct.*;
import pi.banka.domain.AnalitikaIzvoda;
import pi.banka.service.dto.AnalitikaIzvodaDTO;

/**
 * Mapper for the entity {@link AnalitikaIzvoda} and its DTO {@link AnalitikaIzvodaDTO}.
 */
@Mapper(componentModel = "spring", uses = { DnevnoStanjeMapper.class })
public interface AnalitikaIzvodaMapper extends EntityMapper<AnalitikaIzvodaDTO, AnalitikaIzvoda> {
    @Mapping(target = "dnevnoStanje", source = "dnevnoStanje", qualifiedByName = "id")
    AnalitikaIzvodaDTO toDto(AnalitikaIzvoda s);
}
