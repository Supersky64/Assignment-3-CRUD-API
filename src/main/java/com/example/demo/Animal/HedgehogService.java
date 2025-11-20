package com.example.demo.Animal;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HedgehogService {

    @Autowired
    private HedgehogRepo hedgehogRepo;

    /**
     * Method to get all hedgehogs
     *
     * @return List of all hedgehogs
     */

    public Object getAllHedgehogs() {
        return hedgehogRepo.findAll();
    }

    /**
     * Method to get a hedgehogs by ID
     *
     * @param hedgehogId The ID of the hedgehogs to retrieve
     * @return The hedgehogs with the specified ID
     */

    public Hedgehog getHedgehogbyId(@PathVariable long hedgehogId) {
        return hedgehogRepo.findById(hedgehogId).orElse(null);
    }

    /**
     * Method to get hedgehogs by name
     *
     * @param name The name of the hedgehog to search for
     * @return List of hedgehogs with the specified name
     */

    public Object getHedgehogbyName(String name) {
        return hedgehogRepo.getHedgehogsbyName(name);
    }

    /**
     * Method to get hedgehogs by breed in the database
     * 
     * @param breed Breed of the hedgehog to get
     * @return hedgehogs with the specified breed
     */

    public Object getHedgehogbyBreed(String breed) {
        return hedgehogRepo.getHedgehogsbyBreed(breed);
    }

    /**
     * Method to get hedgehogs by status in the database
     * 
     * @param age Age of the hedgehog to get
     * @return hedgehog with the specified age
     */

    public Object getHedgehogbyAge(double age) {
        return hedgehogRepo.getHedgehogsbyAge(age);
    }

     /**
   * Method to get animal by image in the database
   * @param image Image URL of the animal to get
   * @return animal with the specified image
   */
    public Object getHedgehogByImage(String image) {
        return hedgehogRepo.getHedgehogbyImage(image);
    }


    /**
     * Method to create new hedgehog in the database
     * 
     * @param hedgehog Hedgehog to create
     * @return created hedgehog
     */

    public Hedgehog createHedgehog(Hedgehog hedgehog) {
        return hedgehogRepo.save(hedgehog);
    }

    /**
     * Method to update hedgehog in the database
     * 
     * @param hedgehog Hedgehog to update
     * @return updated hedgehog
     */

    public Hedgehog updateHedgehog(long id, Hedgehog hedgehog) {
        hedgehog.setHedgehogId(id);
        return hedgehogRepo.save(hedgehog);
    }

    /**
     * Method to delete hedgehog in the database
     * 
     * @param hedgehog Hedgehog to delete
     */

    public void deleteHedgehog(Long id) {
        hedgehogRepo.deleteById(id);
    }

    /**
     * Method to write hedgehog to JSON file
     * 
     * @param hedgehog Hedgehog to write
     */

    public String writeJson(Hedgehog hedgehog) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("hedgehog.json"), hedgehog);
        return "Hedgehog has been written to JSON file";
    }

    /**
     * Method to read hedgehog in the database
     * 
     * @param hedgehog Hedgehog to read
     * @return contents in JSON
     */

    public Hedgehog readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("hedgehog.json"), Hedgehog.class);
    }
}
