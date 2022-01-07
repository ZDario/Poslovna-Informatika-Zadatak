package pi.banka.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
 * A Klijent.
 */
@Entity
@Table(name = "klijent")
public class Klijent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "broj_licne_karte")
    private String brojLicneKarte;

    @Column(name = "datum_rodjenja")
    private LocalDate datumRodjenja;

    @Column(name = "adresa")
    private String adresa;

    @OneToMany(mappedBy = "klijent")
    private Set<Racun> racunPrivatnihLicas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Klijent id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return this.ime;
    }

    public Klijent ime(String ime) {
        this.setIme(ime);
        return this;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getJmbg() {
        return this.jmbg;
    }

    public Klijent jmbg(String jmbg) {
        this.setJmbg(jmbg);
        return this;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojLicneKarte() {
        return this.brojLicneKarte;
    }

    public Klijent brojLicneKarte(String brojLicneKarte) {
        this.setBrojLicneKarte(brojLicneKarte);
        return this;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public LocalDate getDatumRodjenja() {
        return this.datumRodjenja;
    }

    public Klijent datumRodjenja(LocalDate datumRodjenja) {
        this.setDatumRodjenja(datumRodjenja);
        return this;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public Klijent adresa(String adresa) {
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
            this.racunPrivatnihLicas.forEach(i -> i.setKlijent(null));
        }
        if (racunPrivatnihLicas != null) {
            racunPrivatnihLicas.forEach(i -> i.setKlijent(this));
        }
        this.racunPrivatnihLicas = racunPrivatnihLicas;
    }

    public Klijent racunPrivatnihLicas(Set<Racun> racunPrivatnihLicas) {
        this.setRacunPrivatnihLicas(racunPrivatnihLicas);
        return this;
    }

    public Klijent addRacunPrivatnihLica(Racun racunPrivatnihLica) {
        this.racunPrivatnihLicas.add(racunPrivatnihLica);
        racunPrivatnihLica.setKlijent(this);
        return this;
    }

    public Klijent removeRacunPrivatnihLica(Racun racunPrivatnihLica) {
        this.racunPrivatnihLicas.remove(racunPrivatnihLica);
        racunPrivatnihLica.setKlijent(null);
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Klijent)) {
            return false;
        }
        return id != null && id.equals(((Klijent) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Klijent{" +
            "id=" + getId() +
            ", ime='" + getIme() + "'" +
            ", jmbg='" + getJmbg() + "'" +
            ", brojLicneKarte='" + getBrojLicneKarte() + "'" +
            ", datumRodjenja='" + getDatumRodjenja() + "'" +
            ", adresa='" + getAdresa() + "'" +
            "}";
    }
}
