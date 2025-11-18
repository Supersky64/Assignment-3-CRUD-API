package com.example.demo.Animal;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HedgehogController {

    @Autowired
    private HedgehogService hedgehogService;

    /**
     * Endpoint to get all hedgehogs
     *
     * @return List of all hedgehogs
     */

     @GetMapping("/hedgehog")
     public Object getAllHedgehogs(Model model) {
        // return hedgehogService.getAllHedgehogs();
        model.addAttribute("hedgehogList", hedgehogService.getAllHedgehogs());
        model.addAttribute("title", "All Hedgehogs");
        return "hedgehogs-list";
     }

     /**
   * Endpoint to get a hedgehog by ID
   *
   * @param id The ID of the hedgehog to retrieve
   * @return The hedgehog with the specified ID
   */

    @GetMapping("/hedgehog/{id}")
    public Object getHedgehogbyId(@PathVariable long id, Model model) {
        //return hedgehogService.getHedgehogbyId(id);
        model.addAttribute("hedgehog", hedgehogService.getHedgehogbyId(id));
        model.addAttribute("title", "Hedgehog #: " + id);
        return "hedgehog-details";
    }

    /**
   * Endpoint to get the name of a hedgehog in the database
   * @param name Name of the hedgehog to get
   * @return The hedgehog with the wanted name
   */
    @GetMapping("/hedgehog/name")
    public Object getHedgehogByName(@RequestParam String name, Model model) {
        if (name != null) {
            model.addAttribute("hedgehogList", hedgehogService.getHedgehogbyName(name));
            model.addAttribute("title", "Hedgehog By Name: " + name);
            return "hedgehog-list";
        } else {
            return "redirect:/hedgehog";
        }
    }

    /**
   * Endpoint to get the breed of a hedgehog in the database
   * @param breed Breed of the hedgehog to get
   * @return The hedgehog with the wanted breed
   */
    @GetMapping("/hedgehog/breed/{breed}")
    public Object getHedgehogbyBreed(@PathVariable String breed, Model model) {
        if (breed != null) {
            model.addAttribute("hedgehogList", hedgehogService.getHedgehogbyBreed(breed));
            model.addAttribute("title", "Hedgehog By Breed: " + breed);
            return "hedgehog-list";
        } else {
            return "redirect:/hedgehog";
        }
    }

    /**
   * Endpoint to get the age of a hedgehog in the database
   * @param age Age of the hedgehog to get
   * @return The hedgehog with the wanted age
   */
    @GetMapping("/hedgehog/age")
  public Object getHedgehogbyAge(@RequestParam(name = "age", defaultValue = "1.0") double age, Model model) {
    //return new ResponseEntity<>(hedgehogService.getHedgehogbyAge(age), HttpStatus.OK);

    model.addAttribute("hedgehogList", hedgehogService.getHedgehogbyAge(age));
    model.addAttribute("title", "Age of Hedgehog");
    return "hedgehog-list";
    }

     @GetMapping("/hedgehog/createForm")
    public Object showCreateForm(Model model) {
        Hedgehog newHedgehog = new Hedgehog();
        model.addAttribute("hedgehog", newHedgehog);
        model.addAttribute("title", "Create Hedgehog");
        return "hedgehog-create";
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
