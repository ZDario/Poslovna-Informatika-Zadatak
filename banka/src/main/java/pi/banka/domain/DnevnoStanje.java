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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A DnevnoStanje.
 */
@Entity
@Table(name = "dnevno_stanje")
public class DnevnoStanje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_izvoda")
    private Integer brojIzvoda;

    @Column(name = "datum_izvoda")
    private LocalDate datumIzvoda;

    @Column(name = "prethodno_stanje")
    private Double prethodnoStanje;

    @Column(name = "promet_u_korist")
    private Double prometUKorist;

    @Column(name = "promet_na_teret")
    private Double prometNaTeret;

    @Column(name = "novo_stanje")
    private Double novoStanje;

    @Column(name = "rezervisano")
    private Double rezervisano;

    @OneToMany(mappedBy = "dnevnoStanje")
    private Set<AnalitikaIzvoda> analitikaIzvodas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "dnevnoStanjes", "banka", "klijent" }, allowSetters = true)
    private Racun racunPrivatnihLica;

    public Long getId() {
        return this.id;
    }

    public DnevnoStanje id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojIzvoda() {
        return this.brojIzvoda;
    }

    public DnevnoStanje brojIzvoda(Integer brojIzvoda) {
        this.setBrojIzvoda(brojIzvoda);
        return this;
    }

    public void setBrojIzvoda(Integer brojIzvoda) {
        this.brojIzvoda = brojIzvoda;
    }

    public LocalDate getDatumIzvoda() {
        return this.datumIzvoda;
    }

    public DnevnoStanje datumIzvoda(LocalDate datumIzvoda) {
        this.setDatumIzvoda(datumIzvoda);
        return this;
    }

    public void setDatumIzvoda(LocalDate datumIzvoda) {
        this.datumIzvoda = datumIzvoda;
    }

    public Double getPrethodnoStanje() {
        return this.prethodnoStanje;
    }

    public DnevnoStanje prethodnoStanje(Double prethodnoStanje) {
        this.setPrethodnoStanje(prethodnoStanje);
        return this;
    }

    public void setPrethodnoStanje(Double prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

    public Double getPrometUKorist() {
        return this.prometUKorist;
    }

    public DnevnoStanje prometUKorist(Double prometUKorist) {
        this.setPrometUKorist(prometUKorist);
        return this;
    }

    public void setPrometUKorist(Double prometUKorist) {
        this.prometUKorist = prometUKorist;
    }

    public Double getPrometNaTeret() {
        return this.prometNaTeret;
    }

    public DnevnoStanje prometNaTeret(Double prometNaTeret) {
        this.setPrometNaTeret(prometNaTeret);
        return this;
    }

    public void setPrometNaTeret(Double prometNaTeret) {
        this.prometNaTeret = prometNaTeret;
    }

    public Double getNovoStanje() {
        return this.novoStanje;
    }

    public DnevnoStanje novoStanje(Double novoStanje) {
        this.setNovoStanje(novoStanje);
        return this;
    }

    public void setNovoStanje(Double novoStanje) {
        this.novoStanje = novoStanje;
    }

    public Double getRezervisano() {
        return this.rezervisano;
    }

    public DnevnoStanje rezervisano(Double rezervisano) {
        this.setRezervisano(rezervisano);
        return this;
    }

    public void setRezervisano(Double rezervisano) {
        this.rezervisano = rezervisano;
    }

    public Set<AnalitikaIzvoda> getAnalitikaIzvodas() {
        return this.analitikaIzvodas;
    }

    public void setAnalitikaIzvodas(Set<AnalitikaIzvoda> analitikaIzvodas) {
        if (this.analitikaIzvodas != null) {
            this.analitikaIzvodas.forEach(i -> i.setDnevnoStanje(null));
        }
        if (analitikaIzvodas != null) {
            analitikaIzvodas.forEach(i -> i.setDnevnoStanje(this));
        }
        this.analitikaIzvodas = analitikaIzvodas;
    }

    public DnevnoStanje analitikaIzvodas(Set<AnalitikaIzvoda> analitikaIzvodas) {
        this.setAnalitikaIzvodas(analitikaIzvodas);
        return this;
    }

    public DnevnoStanje addAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
        this.analitikaIzvodas.add(analitikaIzvoda);
        analitikaIzvoda.setDnevnoStanje(this);
        return this;
    }

    public DnevnoStanje removeAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
        this.analitikaIzvodas.remove(analitikaIzvoda);
        analitikaIzvoda.setDnevnoStanje(null);
        return this;
    }

    public Racun getRacunPrivatnihLica() {
        return this.racunPrivatnihLica;
    }

    public void setRacunPrivatnihLica(Racun racunPrivatnihLica) {
        this.racunPrivatnihLica = racunPrivatnihLica;
    }

    public DnevnoStanje racunPrivatnihLica(Racun racunPrivatnihLica) {
        this.setRacunPrivatnihLica(racunPrivatnihLica);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DnevnoStanje)) {
            return false;
        }
        return id != null && id.equals(((DnevnoStanje) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DnevnoStanje{" +
            "id=" + getId() +
            ", brojIzvoda=" + getBrojIzvoda() +
            ", datumIzvoda='" + getDatumIzvoda() + "'" +
            ", prethodnoStanje=" + getPrethodnoStanje() +
            ", prometUKorist=" + getPrometUKorist() +
            ", prometNaTeret=" + getPrometNaTeret() +
            ", novoStanje=" + getNovoStanje() +
            ", rezervisano=" + getRezervisano() +
            "}";
    }
}
