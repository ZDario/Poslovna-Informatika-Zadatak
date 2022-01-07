package pi.banka.service.mapper;

import org.mapstruct.*;
import pi.banka.domain.Klijent;
import pi.banka.service.dto.KlijentDTO;

/**
 * Mapper for the entity {@link Klijent} and its DTO {@link KlijentDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface KlijentMapper extends EntityMapper<KlijentDTO, Klijent> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    KlijentDTO toDtoId(Klijent klijent);
}
