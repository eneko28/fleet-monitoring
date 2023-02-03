package com.example.fleetmanagementdemo.machine;

import org.hibernate.annotations.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(appliesTo = "machine")
public class Machine {

    @Id
    @SequenceGenerator(
        name = "machine_sequence",
        sequenceName = "machine_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "machine_sequence"
    )
    
    private Long id;
    private int version;
    private String location;

    public Machine(){

    }

    public Machine(Long id, int version, String location) {
        this.id = id;
        this.version = version;
        this.location = location;
    }

    public Machine(int version, String location) {
        this.version = version;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Machine [id=" + id + ", version=" + version + ", location=" + location + "]";
    }

}
