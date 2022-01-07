package pi.banka.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link pi.banka.domain.Klijent} entity.
 */
public class KlijentDTO implements Serializable {

    private Long id;

    private String ime;

    private String jmbg;

    private String brojLicneKarte;

    private LocalDate datumRodjenja;

    private String adresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KlijentDTO)) {
            return false;
        }

        KlijentDTO klijentDTO = (KlijentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, klijentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "KlijentDTO{" +
            "id=" + getId() +
            ", ime='" + getIme() + "'" +
            ", jmbg='" + getJmbg() + "'" +
            ", brojLicneKarte='" + getBrojLicneKarte() + "'" +
            ", datumRodjenja='" + getDatumRodjenja() + "'" +
            ", adresa='" + getAdresa() + "'" +
            "}";
    }
}
