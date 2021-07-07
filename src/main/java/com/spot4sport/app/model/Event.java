package com.spot4sport.app.model;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Court courtName;
    @OneToOne
    private Person eventHost;
    private String time;
    private int numberOfUsers;

    public Event() {
    }

    public Event(Long id, String name, Court courtName, Person eventHost, String time, int numberOfUsers) {
        this.id = id;
        this.name = name;
        this.courtName = courtName;
        this.eventHost = eventHost;
        this.time = time;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courtName=" + courtName +
                ", eventHost=" + eventHost +
                ", time=" + time +
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
        if (courtName != null ? !courtName.equals(event.courtName) : event.courtName != null) return false;
        if (eventHost != null ? !eventHost.equals(event.eventHost) : event.eventHost != null) return false;
        return time != null ? time.equals(event.time) : event.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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