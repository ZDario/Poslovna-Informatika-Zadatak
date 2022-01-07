package pi.banka.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link pi.banka.domain.AnalitikaIzvoda} entity.
 */
public class AnalitikaIzvodaDTO implements Serializable {

    private Long id;

    private Integer brojStavke;

    private Double iznos;

    private String duznik;

    private String svrhaPlacanja;

    private String vrstaPlacanja;

    private String primalac;

    private String racunDuznika;

    private String racunPrimaoca;

    private Integer model;

    private String pozivNaBroj;

    private Boolean hitno;

    private DnevnoStanjeDTO dnevnoStanje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojStavke() {
        return brojStavke;
    }

    public void setBrojStavke(Integer brojStavke) {
        this.brojStavke = brojStavke;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public String getDuznik() {
        return duznik;
    }

    public void setDuznik(String duznik) {
        this.duznik = duznik;
    }

    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    public void setSvrhaPlacanja(String svrhaPlacanja) {
        this.svrhaPlacanja = svrhaPlacanja;
    }

    public String getVrstaPlacanja() {
        return vrstaPlacanja;
    }

    public void setVrstaPlacanja(String vrstaPlacanja) {
        this.vrstaPlacanja = vrstaPlacanja;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getRacunDuznika() {
        return racunDuznika;
    }

    public void setRacunDuznika(String racunDuznika) {
        this.racunDuznika = racunDuznika;
    }

    public String getRacunPrimaoca() {
        return racunPrimaoca;
    }

    public void setRacunPrimaoca(String racunPrimaoca) {
        this.racunPrimaoca = racunPrimaoca;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public Boolean getHitno() {
        return hitno;
    }

    public void setHitno(Boolean hitno) {
        this.hitno = hitno;
    }

    public DnevnoStanjeDTO getDnevnoStanje() {
        return dnevnoStanje;
    }

    public void setDnevnoStanje(DnevnoStanjeDTO dnevnoStanje) {
        this.dnevnoStanje = dnevnoStanje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnalitikaIzvodaDTO)) {
            return false;
        }

        AnalitikaIzvodaDTO analitikaIzvodaDTO = (AnalitikaIzvodaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, analitikaIzvodaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnalitikaIzvodaDTO{" +
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
            ", dnevnoStanje=" + getDnevnoStanje() +
            "}";
    }
}
