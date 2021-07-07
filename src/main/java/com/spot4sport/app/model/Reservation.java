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
    private Court courtName;
    @OneToOne
    private Person eventHost;
    private String time;
    private int numberOfUsers;

    public Reservation() {
    }

    public Reservation(Long id, Court courtName, Person eventHost, String time, int numberOfUsers) {
        this.id = id;
        this.courtName = courtName;
        this.eventHost = eventHost;
        this.time = time;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", courtName=" + courtName +
                ", eventHost=" + eventHost +
                ", time='" + time + '\'' +
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
        if (courtName != null ? !courtName.equals(that.courtName) : that.courtName != null) return false;
        if (eventHost != null ? !eventHost.equals(that.eventHost) : that.eventHost != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (courtName != null ? courtName.hashCode() : 0);
        result = 31 * result + (eventHost != null ? eventHost.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + numberOfUsers;
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Court getCourtName() {
        return courtName;
    }

    public void setCourtName(Court courtName) {
        this.courtName = courtName;
    }

    public Person getEventHost() {
        return eventHost;
    }

    public void setEventHost(Person eventHost) {
        this.eventHost = eventHost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
