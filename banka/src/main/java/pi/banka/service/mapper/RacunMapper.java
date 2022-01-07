package pi.banka.service.mapper;

import org.mapstruct.*;
import pi.banka.domain.Racun;
import pi.banka.service.dto.RacunDTO;

/**
 * Mapper for the entity {@link Racun} and its DTO {@link RacunDTO}.
 */
@Mapper(componentModel = "spring", uses = { BankaMapper.class, KlijentMapper.class })
public interface RacunMapper extends EntityMapper<RacunDTO, Racun> {
    @Mapping(target = "banka", source = "banka", qualifiedByName = "id")
    @Mapping(target = "klijent", source = "klijent", qualifiedByName = "id")
    RacunDTO toDto(Racun s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RacunDTO toDtoId(Racun racunPrivatnihLica);
}
