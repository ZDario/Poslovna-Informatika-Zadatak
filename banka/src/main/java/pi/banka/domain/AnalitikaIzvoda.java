package pi.banka.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A AnalitikaIzvoda.
 */
@Entity
@Table(name = "analitika_izvoda")
public class AnalitikaIzvoda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_stavke")
    private Integer brojStavke;

    @Column(name = "iznos")
    private Double iznos;

    @Column(name = "duznik")
    private String duznik;

    @Column(name = "svrha_placanja")
    private String svrhaPlacanja;

    @Column(name = "vrsta_placanja")
    private String vrstaPlacanja;

    @Column(name = "primalac")
    private String primalac;

    @Column(name = "racun_duznika")
    private String racunDuznika;

    @Column(name = "racun_primaoca")
    private String racunPrimaoca;

    @Column(name = "model")
    private Integer model;

    @Column(name = "poziv_na_broj")
    private String pozivNaBroj;

    @Column(name = "hitno")
    private Boolean hitno;

    @ManyToOne
    private DnevnoStanje dnevnoStanje;

    public Long getId() {
        return this.id;
    }

    public AnalitikaIzvoda id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojStavke() {
        return this.brojStavke;
    }

    public AnalitikaIzvoda brojStavke(Integer brojStavke) {
        this.setBrojStavke(brojStavke);
        return this;
    }

    public void setBrojStavke(Integer brojStavke) {
        this.brojStavke = brojStavke;
    }

    public Double getIznos() {
        return this.iznos;
    }

    public AnalitikaIzvoda iznos(Double iznos) {
        this.setIznos(iznos);
        return this;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public String getDuznik() {
        return this.duznik;
    }

    public AnalitikaIzvoda duznik(String duznik) {
        this.setDuznik(duznik);
        return this;
    }

    public void setDuznik(String duznik) {
        this.duznik = duznik;
    }

    public String getSvrhaPlacanja() {
        return this.svrhaPlacanja;
    }

    public AnalitikaIzvoda svrhaPlacanja(String svrhaPlacanja) {
        this.setSvrhaPlacanja(svrhaPlacanja);
        return this;
    }

    public void setSvrhaPlacanja(String svrhaPlacanja) {
        this.svrhaPlacanja = svrhaPlacanja;
    }

    public String getVrstaPlacanja() {
        return this.vrstaPlacanja;
    }

    public AnalitikaIzvoda vrstaPlacanja(String vrstaPlacanja) {
        this.setVrstaPlacanja(vrstaPlacanja);
        return this;
    }

    public void setVrstaPlacanja(String vrstaPlacanja) {
        this.vrstaPlacanja = vrstaPlacanja;
    }

    public String getPrimalac() {
        return this.primalac;
    }

    public AnalitikaIzvoda primalac(String primalac) {
        this.setPrimalac(primalac);
        return this;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getRacunDuznika() {
        return this.racunDuznika;
    }

    public AnalitikaIzvoda racunDuznika(String racunDuznika) {
        this.setRacunDuznika(racunDuznika);
        return this;
    }

    public void setRacunDuznika(String racunDuznika) {
        this.racunDuznika = racunDuznika;
    }

    public String getRacunPrimaoca() {
        return this.racunPrimaoca;
    }

    public AnalitikaIzvoda racunPrimaoca(String racunPrimaoca) {
        this.setRacunPrimaoca(racunPrimaoca);
        return this;
    }

    public void setRacunPrimaoca(String racunPrimaoca) {
        this.racunPrimaoca = racunPrimaoca;
    }

    public Integer getModel() {
        return this.model;
    }

    public AnalitikaIzvoda model(Integer model) {
        this.setModel(model);
        return this;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getPozivNaBroj() {
        return this.pozivNaBroj;
    }

    public AnalitikaIzvoda pozivNaBroj(String pozivNaBroj) {
        this.setPozivNaBroj(pozivNaBroj);
        return this;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public Boolean getHitno() {
        return this.hitno;
    }

    public AnalitikaIzvoda hitno(Boolean hitno) {
        this.setHitno(hitno);
        return this;
    }

    public void setHitno(Boolean hitno) {
        this.hitno = hitno;
    }

    public DnevnoStanje getDnevnoStanje() {
        return this.dnevnoStanje;
    }

    public void setDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanje = dnevnoStanje;
    }

    public AnalitikaIzvoda dnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.setDnevnoStanje(dnevnoStanje);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnalitikaIzvoda)) {
            return false;
        }
        return id != null && id.equals(((AnalitikaIzvoda) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnalitikaIzvoda{" +
            "id=" + getId() +
            ", brojStavke=" + getBrojStavke() +
            ", iznos=" + getIznos() +
            ", duznik='" + getDuznik() + "'" +
            ", svrhaPlacanja='" + getSvrhaPlacanja() + "'" +
            ", vrstaPlacanja='" + getVrstaPlacanja() + "'" +
            ", primalac='" + getPrimalac() + "'" +
            ", racunDuznika='" + getRacunDuznika() + "'" +
            ", racunPrimaoca='" + getRacunPrimaoca() + "'" +
            ", model=" + getModel() +
            ", pozivNaBroj='" + getPozivNaBroj() + "'" +
            ", hitno='" + getHitno() + "'" +
            "}";
    }
}
