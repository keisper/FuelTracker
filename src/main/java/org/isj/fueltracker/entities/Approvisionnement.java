package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Approvisionnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApprovisionnemnt;

    @Column(name = "dateApprovi")
    private Date dateApprovi;
    @Column(name = "volume")
    private int volume;

    @ManyToOne
    @JoinColumn(name="idIndex")
    private Index index;

    @ManyToOne
    @JoinColumn(name="idReservoir")
    private Reservoir reservoir;

    public Approvisionnement(Date dateApprovi, int volume) {
        this.dateApprovi = dateApprovi;
        this.volume = volume;
    }

    public Long getIdApprovisionnemnt() {
        return idApprovisionnemnt;
    }

    public void setIdApprovisionnemnt(Long idApprovisionnemnt) {
        this.idApprovisionnemnt = idApprovisionnemnt;
    }

    public Date getDateApprovi() {
        return dateApprovi;
    }

    public void setDateApprovi(Date dateApprovi) {
        this.dateApprovi = dateApprovi;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approvisionnement that = (Approvisionnement) o;
        return volume == that.volume &&
                Objects.equals(idApprovisionnemnt, that.idApprovisionnemnt) &&
                Objects.equals(dateApprovi, that.dateApprovi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApprovisionnemnt, dateApprovi, volume);
    }
}
