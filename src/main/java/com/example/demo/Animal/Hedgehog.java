package com.example.demo.Animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hedgehogs")
public class Hedgehog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hedgehogId;

    @Column(nullable = false)
    private String name;
    private String description;
    private String breed;
    private double age;


    public Hedgehog(){

    }

    public Hedgehog(long hedgehogId, String name, String description, String breed, double age){
        this.hedgehogId = hedgehogId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Hedgehog(String name, String description, String breed, double age){
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }


    //getters and setters
    public Long getHedgehogId(){
        return hedgehogId;
    }

    public void setHedgehogId(Long hedgehogId){
        this.hedgehogId = hedgehogId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() { 
        return description;
    }

    public void setDescription(String description) { 
        this.description = description;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public double getAge(){
        return age;
    }

    public void setAge(double age){
        this.age = age;
    }

}
