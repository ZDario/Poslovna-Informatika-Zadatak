package pi.banka.service.mapper;

import org.mapstruct.*;
import pi.banka.domain.Banka;
import pi.banka.service.dto.BankaDTO;

/**
 * Mapper for the entity {@link Banka} and its DTO {@link BankaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BankaMapper extends EntityMapper<BankaDTO, Banka> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BankaDTO toDtoId(Banka banka);
}
