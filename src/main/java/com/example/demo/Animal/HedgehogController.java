package com.example.demo.Animal;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HedgehogController {

    @Autowired
    private HedgehogService hedgehogService;

    /**
     * Endpoint to get all hedgehogs
     *
     * @return List of all hedgehogs
     */

     @GetMapping("/hedgehogs")
     public Object getAllHedgehogs() {
         return hedgehogService.getAllHedgehogs();
     }

     /**
   * Endpoint to get a hedgehog by ID
   *
   * @param id The ID of the hedgehog to retrieve
   * @return The hedgehog with the specified ID
   */

    @GetMapping("/hedgehog/{id}")
    public Object getHedgehogbyId(@PathVariable long id) {
        return hedgehogService.getHedgehogbyId(id);
    }

    /**
   * Endpoint to get the name of a hedgehog in the database
   * @param name Name of the hedgehog to get
   * @return The hedgehog with the wanted name
   */
    @GetMapping("/hedgehog/name")
    public Object getHedgehogByName(@RequestParam String name) {
        if (name != null) {
            return hedgehogService.getHedgehogbyName(name);
        } else {
            return hedgehogService.getAllHedgehogs();
        }
    }

    /**
   * Endpoint to get the breed of a hedgehog in the database
   * @param breed Breed of the hedgehog to get
   * @return The hedgehog with the wanted breed
   */
    @GetMapping("/hedgehog/breed/{breed}")
    public Object getHedgehogbyBreed(@PathVariable String breed) {
        if (breed != null) {
            return hedgehogService.getHedgehogbyBreed(breed);
        } else {
            return hedgehogService.getAllHedgehogs();
        }
    }

    /**
   * Endpoint to get the age of a hedgehog in the database
   * @param age Age of the hedgehog to get
   * @return The hedgehog with the wanted age
   */
    @GetMapping("/students/honors")
  public Object getHonorsStudents(@RequestParam(name = "age", defaultValue = "1.0") double age) {
    return new ResponseEntity<>(hedgehogService.getHedgehogbyAge(age), HttpStatus.OK);
    }

    /**
   * Endpoint to create/add a hedgehog in the database
   * @param hedgehog Hedgehog to add
   * @return added hedgehog
   */
    @PostMapping("/hedgehog")
    public Object createHedgehog(@RequestBody Hedgehog hedgehog) {
        return hedgehogService.createHedgehog(hedgehog);
    }

    /**
   * Endpoint to update a hedgehog in the database
   * @param id ID of the hedgehog to update
   * @param hedgehog Hedgehog to update
   * @return updated hedgehog
   */
    @PutMapping("/hedgehog/{id}")
    public Hedgehog updateHedgehog(@PathVariable Long id, @RequestBody Hedgehog hedgehog) {
        return hedgehogService.updateHedgehog(id, hedgehog);
    }

    /**
   * Endpoint to delete a hedgehog in the database
   * @param id ID of the hedgehog to delete
   * @return list of hedgehogs in database after deletion
   */
    @DeleteMapping("/hedgehog/{id}")
    public Object deleteHedgehog(@PathVariable Long id) {
        hedgehogService.deleteHedgehog(id);
        return hedgehogService.getAllHedgehogs();
    }

    /**
   * Endpoint to write hedgehog in JSON file
   * @param hedgehog Hedgehog to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/hedgehog/write")
    public Object writeJson(@RequestBody Hedgehog hedgehog) throws IOException {
        return hedgehogService.writeJson(hedgehog);
    }

    /**
   * Endpoint read Hedgehog JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/hedgehog/read")
    public Object readJson() throws IOException {
        return hedgehogService.readJson();
    }
     
}
