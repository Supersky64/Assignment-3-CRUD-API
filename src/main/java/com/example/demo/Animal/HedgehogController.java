package com.example.demo.Animal;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("hedgehogs", hedgehogService.getAllHedgehogs());
        model.addAttribute("title", "All Hedgehogs");
        return "hedgehog-list";
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


     /**
   * Endpoint to get the image of a animal in the database
   * @param image Image URL of the animal to get
   * @return The animal with the wanted image
   */
    @GetMapping("/hedgehog/image")
    public Object getAnimalByImage(@RequestParam String image, Model model) {
        if (image != null) {
            model.addAttribute("hedgehog", hedgehogService.getHedgehogByImage(image));
            model.addAttribute("title", "Hedgehog by Image: " + image);
            return "hedgehog-list";
        } else {
            return "redirect:/hedgehog";
        }
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
    public Object createHedgehog(Hedgehog hedgehog) {
        Hedgehog newHedgehog = hedgehogService.createHedgehog(hedgehog);
        return "redirect:/hedgehog/" + newHedgehog.getHedgehogId();
    }

    @GetMapping("/hedgehog/updateForm/{id}")
    public Object showupdateHedgehog(@PathVariable Long id, Model model) {
        Hedgehog hedgehog = hedgehogService.getHedgehogbyId(id);
        model.addAttribute("hedgehog", hedgehog);
        model.addAttribute("title", "Update Hedgehog: " + id);
        return "hedgehog-update";
    }

    /**
   * Endpoint to update a hedgehog in the database
   * @param id ID of the hedgehog to update
   * @param hedgehog Hedgehog to update
   * @return updated hedgehog
   */
    @PostMapping("/hedgehog/update/{id}")
    public Object updateHedgehog(@PathVariable Long id, Hedgehog hedgehog) {
        hedgehogService.updateHedgehog(id, hedgehog);
        return "redirect:/hedgehog/" + id;
    }



    /**
   * Endpoint to delete a hedgehog in the database
   * @param id ID of the hedgehog to delete
   * @return list of hedgehogs in database after deletion
   */
    @GetMapping("/hedgehog/delete/{id}")
    public Object deleteHedgehog(@PathVariable Long id) {
        hedgehogService.deleteHedgehog(id);
        return "redirect:/hedgehog";
    }

     
}
