package pi.banka.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A Banka.
 */
@Entity
@Table(name = "banka")
public class Banka implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "pib")
    private String pib;

    @Column(name = "sifra_banke")
    private String sifraBanke;

    @Column(name = "adresa")
    private String adresa;

    @OneToMany(mappedBy = "banka")
    private Set<Racun> racunPrivatnihLicas = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Banka id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Banka naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return this.pib;
    }

    public Banka pib(String pib) {
        this.setPib(pib);
        return this;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getSifraBanke() {
        return this.sifraBanke;
    }

    public Banka sifraBanke(String sifraBanke) {
        this.setSifraBanke(sifraBanke);
        return this;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public Banka adresa(String adresa) {
        this.setAdresa(adresa);
        return this;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Set<Racun> getRacunPrivatnihLicas() {
        return this.racunPrivatnihLicas;
    }

    public void setRacunPrivatnihLicas(Set<Racun> racunPrivatnihLicas) {
        if (this.racunPrivatnihLicas != null) {
            this.racunPrivatnihLicas.forEach(i -> i.setBanka(null));
        }
        if (racunPrivatnihLicas != null) {
            racunPrivatnihLicas.forEach(i -> i.setBanka(this));
        }
        this.racunPrivatnihLicas = racunPrivatnihLicas;
    }

    public Banka racunPrivatnihLicas(Set<Racun> racunPrivatnihLicas) {
        this.setRacunPrivatnihLicas(racunPrivatnihLicas);
        return this;
    }

    public Banka addRacunPrivatnihLica(Racun racunPrivatnihLica) {
        this.racunPrivatnihLicas.add(racunPrivatnihLica);
        racunPrivatnihLica.setBanka(this);
        return this;
    }

    public Banka removeRacunPrivatnihLica(Racun racunPrivatnihLica) {
        this.racunPrivatnihLicas.remove(racunPrivatnihLica);
        racunPrivatnihLica.setBanka(null);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Banka)) {
            return false;
        }
        return id != null && id.equals(((Banka) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Banka{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", pib='" + getPib() + "'" +
            ", sifraBanke='" + getSifraBanke() + "'" +
            ", adresa='" + getAdresa() + "'" +
            "}";
    }
}
