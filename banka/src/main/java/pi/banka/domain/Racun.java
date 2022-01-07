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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A RacunPrivatnihLica.
 */
@Entity
@Table(name = "racun_privatnih_lica")
public class Racun implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_racuna")
    private String brojRacuna;

    @Column(name = "datum_otvaranja")
    private LocalDate datumOtvaranja;

    @OneToMany(mappedBy = "racunPrivatnihLica")
    private Set<DnevnoStanje> dnevnoStanjes = new HashSet<>();

    @ManyToOne
    private Banka banka;

    @ManyToOne
    private Klijent klijent;

    public Long getId() {
        return this.id;
    }

    public Racun id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return this.brojRacuna;
    }

    public Racun brojRacuna(String brojRacuna) {
        this.setBrojRacuna(brojRacuna);
        return this;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public LocalDate getDatumOtvaranja() {
        return this.datumOtvaranja;
    }

    public Racun datumOtvaranja(LocalDate datumOtvaranja) {
        this.setDatumOtvaranja(datumOtvaranja);
        return this;
    }

    public void setDatumOtvaranja(LocalDate datumOtvaranja) {
        this.datumOtvaranja = datumOtvaranja;
    }

    public Set<DnevnoStanje> getDnevnoStanjes() {
        return this.dnevnoStanjes;
    }

    public void setDnevnoStanjes(Set<DnevnoStanje> dnevnoStanjes) {
        if (this.dnevnoStanjes != null) {
            this.dnevnoStanjes.forEach(i -> i.setRacunPrivatnihLica(null));
        }
        if (dnevnoStanjes != null) {
            dnevnoStanjes.forEach(i -> i.setRacunPrivatnihLica(this));
        }
        this.dnevnoStanjes = dnevnoStanjes;
    }

    public Racun dnevnoStanjes(Set<DnevnoStanje> dnevnoStanjes) {
        this.setDnevnoStanjes(dnevnoStanjes);
        return this;
    }

    public Racun addDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanjes.add(dnevnoStanje);
        dnevnoStanje.setRacunPrivatnihLica(this);
        return this;
    }

    public Racun removeDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanjes.remove(dnevnoStanje);
        dnevnoStanje.setRacunPrivatnihLica(null);
        return this;
    }

    public Banka getBanka() {
        return this.banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public Racun banka(Banka banka) {
        this.setBanka(banka);
        return this;
    }

    public Klijent getKlijent() {
        return this.klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Racun klijent(Klijent klijent) {
        this.setKlijent(klijent);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Racun)) {
            return false;
        }
        return id != null && id.equals(((Racun) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RacunPrivatnihLica{" +
            "id=" + getId() +
            ", brojRacuna='" + getBrojRacuna() + "'" +
            ", datumOtvaranja='" + getDatumOtvaranja() + "'" +
            "}";
    }
}
