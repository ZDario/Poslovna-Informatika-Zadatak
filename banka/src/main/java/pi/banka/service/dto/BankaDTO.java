package pi.banka.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link pi.banka.domain.Banka} entity.
 */
public class BankaDTO implements Serializable {

    private Long id;

    private String naziv;

    private String pib;

    private String sifraBanke;

    private String adresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
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
        if (!(o instanceof BankaDTO)) {
            return false;
        }

        BankaDTO bankaDTO = (BankaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bankaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankaDTO{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", pib='" + getPib() + "'" +
            ", sifraBanke='" + getSifraBanke() + "'" +
            ", adresa='" + getAdresa() + "'" +
            "}";
    }
}
