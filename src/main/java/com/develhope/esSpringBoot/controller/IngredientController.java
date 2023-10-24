package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Ingredient;
import com.develhope.esSpringBoot.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping("/add-ingredient")
    public ResponseEntity   createIngredient(@RequestBody Ingredient ingredient){
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok("Ingredient added");
    }

    @DeleteMapping("/delete-ingredient/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok("Ingredient deleted");
    }

    @GetMapping("/get-ingredient/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id){
        Optional<Ingredient> opt = ingredientService.getIngredient(id);
        if(opt.isPresent()){
            return ResponseEntity.ok("Id : " + opt.get().getId()
                    + "\nName : " + opt.get().getName()
                    + "\nVegetarian : " + opt.get().isVegetarian()
                    + "\nVegan : " + opt.get().isVegan()
                    + "\nGluten Free : " + opt.get().isGlutenFree()
                    + "\nLactose Free : "  + opt.get().isLactoseFree());
        }
        return ResponseEntity.badRequest().body("No ingredient for  ID " + id);
    }

    @PutMapping("/update-ingredient/{id}")
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id){
        ingredientService.updateIngredient(ingredient,id);
        return ResponseEntity.ok("Ingredient updated!");
    }
}
