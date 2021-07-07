package com.spot4sport.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Court {

    private @Id @GeneratedValue Long id;
    private String name;
    private String playgrounds;
    private String address;

    public String getPlaygrounds() {
        return playgrounds;
    }

    @Override
    public String toString() {
        return "Court{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playgrounds='" + playgrounds + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setPlaygrounds(String playgrounds) {
        this.playgrounds = playgrounds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Court() {}

    public Court(String name) {
        this.name = name;
    }

    public Court(String name, String playgrounds, String address) {
        this.name = name;
        this.playgrounds = playgrounds;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Court)) return false;
        Court court = (Court) o;
        return getId().equals(court.getId()) &&
                getName().equals(court.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

}
