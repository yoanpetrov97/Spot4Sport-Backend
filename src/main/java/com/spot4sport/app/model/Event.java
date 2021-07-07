package com.spot4sport.app.model;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Court court;
    @OneToOne
    private Person organizer;
    private String time;
    private String sport;
    private int numberOfUsers;

    public Event() {
    }

    public Event(String name, Court court, Person organizer, String time, String sport, int numberOfUsers) {
        this.name = name;
        this.court = court;
        this.organizer = organizer;
        this.time = time;
        this.sport = sport;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courtName=" + court +
                ", organizer=" + organizer +
                ", time=" + time +
                ", sport=" + sport +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (numberOfUsers != event.numberOfUsers) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (court != null ? !court.equals(event.court) : event.court != null) return false;
        if (organizer != null ? !organizer.equals(event.organizer) : event.organizer != null) return false;
        if (sport != null ? !sport.equals(event.sport) : event.sport != null) return false;
        return time != null ? time.equals(event.time) : event.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court courtName) {
        this.court = courtName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
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
