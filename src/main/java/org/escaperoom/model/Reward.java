package org.escaperoom.model;

public class Reward {
    private int id;
    private String name;
    private String description;
    private double value; // valor en euros de la recompensa

     public Reward(int id, String name, String description, double value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        }

    public Reward() {
        }

    // Getters y setters
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

    public String getDescription() {
        return description;
        }

    public void setDescription(String description) {
        this.description = description;
        }

    public double getValue() {
        return value;
        }

    public void setValue(double value) {
        this.value = value;
        }

     @Override
     public String toString() {
        return "Reward [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value + "]";
        }
    }