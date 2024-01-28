package uz.kpi.motors.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Periods")
public class Periods {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public Periods(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Periods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
