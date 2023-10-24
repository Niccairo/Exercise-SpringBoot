package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Ingredient;
import com.develhope.esSpringBoot.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//PUO ANDARE BENE QUESTA LOGICA DEL TRY CATCH CHE HO USATO NEL CODICE?
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
        try{
            ingredientService.deleteIngredient(id);
            return ResponseEntity.ok("Ingredient deleted!");
        }catch(EntityNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-ingredient/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id){
        try{
            Optional<Ingredient> opt = ingredientService.getIngredient(id);
            return ResponseEntity.ok(opt.get().toString());  //qui ho usato il toString() per scrivere molto meno codice, qual'è la versione migliore?
            /*       "Id : " + opt.get().getId()
                    + "\nName : " + opt.get().getName()
                    + "\nVegetarian : " + opt.get().isVegetarian()
                    + "\nVegan : " + opt.get().isVegan()
                    + "\nGluten Free : " + opt.get().isGlutenFree()
                    + "\nLactose Free : "  + opt.get().isLactoseFree());      */
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update-ingredient/{id}")
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id){
        try{
            ingredientService.updateIngredient(ingredient,id);
            return ResponseEntity.ok("Ingredient updated!");
        }catch(EntityNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
