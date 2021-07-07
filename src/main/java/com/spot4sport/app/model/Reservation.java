package com.spot4sport.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Court court;
    @OneToOne
    private Person organizer;
    private String time;
    private String sport;
    private int numberOfUsers;

    public Reservation() {
    }

    public Reservation(Court court, Person organizer, String time, String sport, int numberOfUsers) {
        this.court = court;
        this.organizer = organizer;
        this.time = time;
        this.sport = sport;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", courtName=" + court +
                ", organizer=" + organizer +
                ", time='" + time + '\'' +
                ", sport='" + sport + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (numberOfUsers != that.numberOfUsers) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (court != null ? !court.equals(that.court) : that.court != null) return false;
        if (organizer != null ? !organizer.equals(that.organizer) : that.organizer != null) return false;
        if (sport != null ? !sport.equals(that.sport) : that.sport != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (court != null ? court.hashCode() : 0);
        result = 31 * result + (organizer != null ? organizer.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        result = 31 * result + numberOfUsers;
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court courtName) {
        this.court = courtName;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
