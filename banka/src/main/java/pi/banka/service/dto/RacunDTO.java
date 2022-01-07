package pi.banka.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link pi.banka.domain.Racun} entity.
 */
public class RacunDTO implements Serializable {

    private Long id;

    private String brojRacuna;

    private LocalDate datumOtvaranja;

    private BankaDTO banka;

    private KlijentDTO klijent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public LocalDate getDatumOtvaranja() {
        return datumOtvaranja;
    }

    public void setDatumOtvaranja(LocalDate datumOtvaranja) {
        this.datumOtvaranja = datumOtvaranja;
    }

    public BankaDTO getBanka() {
        return banka;
    }

    public void setBanka(BankaDTO banka) {
        this.banka = banka;
    }

    public KlijentDTO getKlijent() {
        return klijent;
    }

    public void setKlijent(KlijentDTO klijent) {
        this.klijent = klijent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacunDTO)) {
            return false;
        }

        RacunDTO racunPrivatnihLicaDTO = (RacunDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, racunPrivatnihLicaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RacunPrivatnihLicaDTO{" +
            "id=" + getId() +
            ", brojRacuna='" + getBrojRacuna() + "'" +
            ", datumOtvaranja='" + getDatumOtvaranja() + "'" +
            ", banka=" + getBanka() +
            ", klijent=" + getKlijent() +
            "}";
    }
}
