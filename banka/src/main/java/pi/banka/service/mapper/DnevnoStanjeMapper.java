package pi.banka.service.mapper;

import org.mapstruct.*;
import pi.banka.domain.DnevnoStanje;
import pi.banka.service.dto.DnevnoStanjeDTO;

/**
 * Mapper for the entity {@link DnevnoStanje} and its DTO {@link DnevnoStanjeDTO}.
 */
@Mapper(componentModel = "spring", uses = { RacunMapper.class })
public interface DnevnoStanjeMapper extends EntityMapper<DnevnoStanjeDTO, DnevnoStanje> {
    @Mapping(target = "racunPrivatnihLica", source = "racunPrivatnihLica", qualifiedByName = "id")
    DnevnoStanjeDTO toDto(DnevnoStanje s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DnevnoStanjeDTO toDtoId(DnevnoStanje dnevnoStanje);
}
